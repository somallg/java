package com.xyzws.time;

import java.rmi.RemoteException;

/**
 * Created by somallg on 9/26/14.
 */
public class TimeServiceBean implements TimeService {
    @Override
    public String getDateTime(String name) throws RemoteException {
        System.out.println("TimeServiceBean: getDateTime() invoked");

        return "lala";
    }
}
