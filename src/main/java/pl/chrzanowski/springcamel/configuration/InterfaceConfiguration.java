package pl.chrzanowski.springcamel.configuration;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.chrzanowski.springcamel.utils.ConnectorConfiguration;
import pl.chrzanowski.springcamel.utils.InfoMessage;
import pl.chrzanowski.springcamel.utils.Validator;

@Configuration
public class InterfaceConfiguration {

    @Bean
    public ConnectorConfiguration configuration(){
        ConnectorConfiguration configuration = new ConnectorConfiguration();
        configuration.setInfoMessage(infoMessage());
        configuration.setValidator(validator());
        return configuration;
    }

    @Bean
    public Validator validator(){
        return Validator.create3NumValidator();
    }

    @Bean
    public InfoMessage infoMessage(){
        return InfoMessage.createMessageFor3NumInterace();
    }

    @Bean("meter")
    public Meter meter(){
        return new Meter();
    }
    @Bean
    public MetricRegistry metricRegistry(){
       MetricRegistry  metricRegistry = new MetricRegistry();
        metricRegistry.register("error", meter());
        return metricRegistry;
    }







}
