package org.osmand.didemo.config;

import org.osmand.didemo.examplebeans.FakeDataSource;
import org.osmand.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

    @Value("${db.username}")
    String user;

    @Value("${db.password}")
    String password;

    @Value("${db.url}")
    String dbUrl;

    @Value("${jms.username}")
    String jmsUser;

    @Value("${jms.password}")
    String jmsPassword;

    @Value("${jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setDbUrl(dbUrl);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        //fakeJmsBroker.setJmsUrl(env.getProperty("JMS_URL"));
        fakeJmsBroker.setJmsUrl(jmsUrl);
        return fakeJmsBroker;
    }

}
