package pl.chrzanowski.springcamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chrzanowski.springcamel.processors.CustomProcessor;

@Component
public class CustomRouteBuilder extends RouteBuilder {

    @Autowired
    CustomProcessor customProcessor;


    CustomRouteBuilder(CustomProcessor customProcessor){
        this.customProcessor = customProcessor;
    }

    @Override
    public void configure() throws Exception {
        from("mq:queue:DEV.QUEUE.1")
                .process(customProcessor)
                .to("mq:queue:DEV.QUEUE.2");
    }
}
