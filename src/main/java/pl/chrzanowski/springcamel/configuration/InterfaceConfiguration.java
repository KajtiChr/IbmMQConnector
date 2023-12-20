package pl.chrzanowski.springcamel.configuration;

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

}
