package pl.chrzanowski.springcamel.exceptionHandling;

import java.text.DecimalFormat;

public class ErrorMessage {

    private static final DecimalFormat ErrorNumFormat = new DecimalFormat("00");

    private int errorNumber;

    private String errorMessage;

    public ErrorMessage(ErrorMessageImpl ref, String errorMessage, int errorNumber){
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
    }


    public String getErrorNumFormat() {
        return "ERR-" + ErrorNumFormat.format(this.errorNumber);
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public String getErrorMessage() {
        return this.getErrorNumFormat()+": " + this.errorMessage;
    }
}
