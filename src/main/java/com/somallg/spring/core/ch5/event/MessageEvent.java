package com.somallg.spring.core.ch5.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);

        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }

}
