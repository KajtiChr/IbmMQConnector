package pl.chrzanowski.springcamel.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class Validator {

    private Pattern pattern = null;

    private static Map<String, Validator> validators = new HashMap<>();

    private Validator(String s){
        this.pattern = Pattern.compile(s);
    }

    public boolean validate(String s){
        return s != null & this.pattern.matcher(s).matches();
    }

    public boolean contains(String s){
        return s != null && this.pattern.matcher(s).find();
    }

    public static Validator create3NumValidator(){
        return create("^[0-9]{3}$");
    }

    public static Validator create4NumValidator(){
        return create("^[0-9]{4}$");
    }

    private static Validator create(String regexp) {
        Validator val = validators.get(regexp);
        if (val == null){
            Class buff = Validator.class;
            synchronized (Validator.class){
                val = validators.get(regexp);
                if(val == null){
                    val = new Validator(regexp);
                    validators.put(regexp, val);
                }
            }
        }

        return val;
    }


}
