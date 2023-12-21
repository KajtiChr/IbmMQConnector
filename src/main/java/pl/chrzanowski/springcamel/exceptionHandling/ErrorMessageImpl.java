package pl.chrzanowski.springcamel.exceptionHandling;

public class ErrorMessageImpl {

    protected static final ErrorMessageImpl nullMessImpl = null;

    private static final String ERR_00 = "";

    public static final ErrorMessage SUCCESS;

    private static final String ERR_01 = "Message hasn't been denied by Validator";

    public static final ErrorMessage VALIDATOR;

    private static final String ERR_02 = "Message is empty!";

    public static final ErrorMessage EMPTY_MESS;

    private static final String ERR_03 = "Validator is equal null";

    public static final ErrorMessage NULL_VALLIDATOR;

    static{
        SUCCESS = new ErrorMessage(nullMessImpl, ERR_00, 00);
        VALIDATOR = new ErrorMessage(nullMessImpl, ERR_01, 01);
        EMPTY_MESS = new ErrorMessage(nullMessImpl, ERR_02, 02);
        NULL_VALLIDATOR = new ErrorMessage(nullMessImpl, ERR_03, 03);
    }



}
