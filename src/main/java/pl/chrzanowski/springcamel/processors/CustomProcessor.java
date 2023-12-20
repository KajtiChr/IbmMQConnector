package pl.chrzanowski.springcamel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chrzanowski.springcamel.configuration.InterfaceConfiguration;

@Component
public class CustomProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(CustomProcessor.class);

    @Autowired
    public InterfaceConfiguration interfaceConfiguration;

    public CustomProcessor(InterfaceConfiguration interfaceConfiguration) {
        this.interfaceConfiguration = interfaceConfiguration;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        logger.info(interfaceConfiguration.infoMessage().toString());

        logger.info(exchange.getIn().getBody().toString());

        interfaceConfiguration.validator().validate(exchange.getIn().getBody().toString());

        logger.info("");


    }
}
