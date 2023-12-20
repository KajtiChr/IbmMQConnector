package pl.chrzanowski.springcamel.processors;

import com.ibm.disthub2.client.Connector;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chrzanowski.springcamel.configuration.InterfaceConfiguration;
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

        configuration.getValidator().validate(exchange.getIn().getBody().toString());

        logger.info("");


    }

    private void parseMessage(String mess) throws ValidationException{
        Validator val = configuration.getValidator();

        if(val == null){
            throw new ValidationException();
        }

        if(!val.validate(mess)){
            throw new ValidationException();
        }

    }

}
