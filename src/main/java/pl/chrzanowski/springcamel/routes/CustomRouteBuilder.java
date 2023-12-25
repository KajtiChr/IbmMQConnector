package pl.chrzanowski.springcamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chrzanowski.springcamel.exceptionHandling.ValidatorException;
import pl.chrzanowski.springcamel.processors.CustomProcessor;
import pl.chrzanowski.springcamel.processors.ErrorHandlingProcessor;

@Component
public class CustomRouteBuilder extends RouteBuilder {

    @Autowired
    CustomProcessor customProcessor;

    @Autowired
    ErrorHandlingProcessor errorHandlingProcessor;


    CustomRouteBuilder(CustomProcessor customProcessor, ErrorHandlingProcessor errorHandlingProcessor){
        this.customProcessor = customProcessor;
        this.errorHandlingProcessor = errorHandlingProcessor;
    }

    @Override
    public void configure() throws Exception {
        onException(ValidatorException.class)
                .process(errorHandlingProcessor)
                .to("mq:queue:DEV.DEAD.LETTER.QUEUE");

        from("mq:queue:DEV.QUEUE.1")
                .process(customProcessor)
                .to("mq:queue:DEV.QUEUE.2");
    }
}
