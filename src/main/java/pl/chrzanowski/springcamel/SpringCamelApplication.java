package pl.chrzanowski.springcamel;

import com.ibm.mq.jms.MQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.JMSException;

@SpringBootApplication
public class SpringCamelApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringCamelApplication.class, args);
    }

}
