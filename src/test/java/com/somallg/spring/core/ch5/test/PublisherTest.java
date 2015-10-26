package com.somallg.spring.core.ch5.test;

import com.somallg.spring.core.ch5.event.MessageEvent;
import com.somallg.spring.core.ch5.event.MessageEventListener;
import com.somallg.spring.core.ch5.event.Publisher;
import com.somallg.spring.core.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:ch5/spring-event.xml")
public class PublisherTest extends SpringTest {

    @Autowired
    private Publisher publisher;

    @Autowired
    MessageEventListener messageEventListener;

    @Test
    public void testPublish() throws Exception {
        publisher.publish("Hello Lala");
        publisher.publish("Hello LBL");

        List<MessageEvent> messageEvent = messageEventListener.getMessageEvent();
        assertEquals(2, messageEvent.size());
        assertEquals("Hello Lala", messageEvent.get(0).getMessage());
        assertEquals("Hello LBL", messageEvent.get(1).getMessage());
    }

}