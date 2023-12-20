package pl.chrzanowski.springcamel.utils;


public class ConnectorConfiguration {

    private Validator validator;

    private InfoMessage infoMessage;


    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public InfoMessage getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(InfoMessage infoMessage) {
        this.infoMessage = infoMessage;
    }
}
