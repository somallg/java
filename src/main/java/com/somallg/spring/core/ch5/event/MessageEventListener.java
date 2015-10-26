package com.somallg.spring.core.ch5.event;

import org.springframework.context.ApplicationListener;

import java.util.ArrayList;
import java.util.List;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

    private List<MessageEvent> messageEvent = new ArrayList<MessageEvent>();

    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("Received message " + event.getMessage());
        this.messageEvent.add(event);
    }

    public List<MessageEvent> getMessageEvent() {
        return messageEvent;
    }

    public void setMessageEvent(List<MessageEvent> messageEvent) {
        this.messageEvent = messageEvent;
    }
}
