package com.xyzws.time;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by somallg on 9/26/14.
 */
public interface TimeService extends Remote {
    public String getDateTime(String name) throws RemoteException;
}
