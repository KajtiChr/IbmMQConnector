package pl.chrzanowski.springcamel.exceptionHandling;

import java.util.ArrayList;
import java.util.List;

public class ValidatorException extends Exception{

    private static final long serialVersionUID = 1235125L;

    ErrorMessage errorMessage;

    private List<ValidatorException> chained = new ArrayList<>();

    public ValidatorException(ErrorMessage err){
        super(err.getErrorMessage());
        this.errorMessage = err;
    }

    public ValidatorException(ErrorMessage err, Throwable cause){
        super(err.getErrorMessage(), cause);
        this.errorMessage = err;
    }

    public void chainException(ValidatorException ex){
        this.chained.add(ex);
    }

    public List<ValidatorException> getChainedExceptions(){
        return this.chained;
    }

}
