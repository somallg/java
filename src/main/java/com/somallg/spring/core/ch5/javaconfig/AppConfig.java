package com.somallg.spring.core.ch5.javaconfig;

import com.somallg.spring.core.ch5.event.MessageEventListener;
import com.somallg.spring.core.ch5.event.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*
     	<bean id="publisher" class="com.somallg.Publisher" />
    */
    @Bean
    public Publisher publisher() {
        return new Publisher();
    }

    /*
     	<bean id="messageEventListener" class="com.somallg.MessageEventListener" />
    */
    @Bean
    public MessageEventListener messageEventListener() {
        return new MessageEventListener();
    }
}
