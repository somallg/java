package com.somallg.javaws.ch02.ts;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by somallg on 5/12/14.
 */

/**
 * @WebServer property endPointInterface links SIB to the SEI
 * Method implementations are not annotated
 */

@WebService(endpointInterface = "com.somallg.javaws.ch02.ts.TimeServer")
public class TimeServerImpl implements TimeServer {
    @Override
    public String getTimeAsString() {
        return new Date().toString();
    }

    @Override
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
}