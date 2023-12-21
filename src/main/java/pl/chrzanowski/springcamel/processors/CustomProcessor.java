package pl.chrzanowski.springcamel.processors;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chrzanowski.springcamel.configuration.InterfaceConfiguration;
import pl.chrzanowski.springcamel.exceptionHandling.ErrorMessageImpl;
import pl.chrzanowski.springcamel.exceptionHandling.ValidatorException;
import pl.chrzanowski.springcamel.utils.ConnectorConfiguration;
import pl.chrzanowski.springcamel.utils.Validator;



@Component
public class CustomProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(CustomProcessor.class);

    @Autowired
    public ConnectorConfiguration configuration;

    public CustomProcessor(ConnectorConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        logger.info(configuration.getInfoMessage().toString());

        logger.info(exchange.getIn().getBody().toString());

        Validator validator = configuration.getValidator();

        parseMessage(exchange.getIn().getBody().toString(), validator);

        logger.info("Message has been processed properly");


    }

    private void parseMessage(String mess, Validator validator) throws ValidatorException {

        if(validator == null){
            throw new ValidatorException(ErrorMessageImpl.NULL_VALLIDATOR);
        }

        if(!validator.validate(mess)){
            throw new ValidatorException(ErrorMessageImpl.VALIDATOR);
        }

    }

}
