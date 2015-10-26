package com.somallg.javaws.ch1.timeservice.ws.impl;

/**
 * Created by somallg on 5/12/14.
 */

import com.somallg.javaws.ch1.timeservice.domain.Person;
import com.somallg.javaws.ch1.timeservice.ws.TimeServer;

import javax.jws.WebService;
import java.util.Date;

/**
 * @WebServer property endPointInterface links SIB to the SEI
 * Method implementations are not annotated
 */

@WebService(endpointInterface = "com.somallg.javaws.ch1.timeservice.ws.TimeServer")
public class TimeServerImpl implements TimeServer {
    @Override
    public String getTimeAsString() {
        return new Date().toString();
    }

    @Override
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }

    @Override
    public Date getTime() {
        return new Date();
    }

    @Override
    public Person getPerson() {
        return new Person("Ly Bao Linh", 23);
    }
}
