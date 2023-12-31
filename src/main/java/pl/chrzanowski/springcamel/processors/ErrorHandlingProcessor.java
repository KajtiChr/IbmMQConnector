package pl.chrzanowski.springcamel.processors;

import com.codahale.metrics.Meter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandlingProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(ErrorHandlingProcessor.class);


    @Override
    public void process(Exchange exchange) throws Exception {

        logger.error("Message is corrupted body of message: " + exchange.getIn().getBody());
//        todo we gace check what's trouble related with message
    }
}
