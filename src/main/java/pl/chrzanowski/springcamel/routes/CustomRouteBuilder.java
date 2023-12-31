package pl.chrzanowski.springcamel.routes;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chrzanowski.springcamel.exceptionHandling.ValidatorException;
import pl.chrzanowski.springcamel.processors.CustomProcessor;
import pl.chrzanowski.springcamel.processors.ErrorHandlingProcessor;

@Component
public class CustomRouteBuilder extends RouteBuilder {


    @Autowired
    Meter meter;

    @Autowired
    CustomProcessor customProcessor;

    @Autowired
    ErrorHandlingProcessor errorHandlingProcessor;

    @Autowired
    MetricRegistry metricRegistry;


    CustomRouteBuilder(CustomProcessor customProcessor, ErrorHandlingProcessor errorHandlingProcessor,
                       MetricRegistry metricRegistry, Meter meter){
        this.customProcessor = customProcessor;
        this.errorHandlingProcessor = errorHandlingProcessor;
        this.metricRegistry = metricRegistry;
        this.meter = meter;
    }

    @Override
    public void configure() throws Exception {
        onException(ValidatorException.class)
                .process(errorHandlingProcessor)
                .to("bean:meter?method=mark()")
                .log("Error count is equal: " + "${bean:meter?method=getCount()}")
                .to("mq:queue:DEV.DEAD.LETTER.QUEUE");

        from("mq:queue:DEV.QUEUE.1")
                .process(customProcessor)
                .to("mq:queue:DEV.QUEUE.2");
    }
}
