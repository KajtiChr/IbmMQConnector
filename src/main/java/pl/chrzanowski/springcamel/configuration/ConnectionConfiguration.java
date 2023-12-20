package pl.chrzanowski.springcamel.configuration;

import com.ibm.mq.jms.MQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;

import javax.jms.JMSException;

@Configuration
public class ConnectionConfiguration {


    @Bean
    public MQConnectionFactory mqConnectiontionFactory() throws JMSException {
        MQConnectionFactory mq = new MQConnectionFactory();
        mq.setAppName("demoTest");
        mq.setHostName("localhost");
        mq.setPort(1414);
        mq.setChannel("DEV.APP.SVRCONN");
        mq.setQueueManager("QM1");
        mq.setTransportType(1);

        return mq;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() throws JMSException {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(mqConnectiontionFactory());
        cachingConnectionFactory.setSessionCacheSize(10);

        return cachingConnectionFactory;
    }

    @Bean
    public UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter() throws JMSException {
        UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter = new UserCredentialsConnectionFactoryAdapter();
        userCredentialsConnectionFactoryAdapter.setTargetConnectionFactory(mqConnectiontionFactory());
        userCredentialsConnectionFactoryAdapter.setUsername("admin");
        userCredentialsConnectionFactoryAdapter.setPassword("passw0rd");

        return userCredentialsConnectionFactoryAdapter;
    }

    @Bean("mq")
    public JmsComponent jmsComponent() throws JMSException {
        JmsComponent jmsComponent = new JmsComponent();
        jmsComponent.setConnectionFactory(mqConnectiontionFactory());

        return jmsComponent;
    }




}
