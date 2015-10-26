package com.somallg.spring.core.ch16.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by somallg on 11/9/14.
 */
public class SimpleMessageListener2 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("Message received 2 : " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
