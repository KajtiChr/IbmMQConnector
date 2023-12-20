package pl.chrzanowski.springcamel.utils;

public class InfoMessage {

    private String message;

    public InfoMessage(String message) {
        this.message = message;
    }

    public static InfoMessage createMessageFor3NumInterace(){
        return createMessage("This message providing 3 num validator");
    }

    public static InfoMessage createMessage(String mess){
       return new InfoMessage(mess);
    }
}
