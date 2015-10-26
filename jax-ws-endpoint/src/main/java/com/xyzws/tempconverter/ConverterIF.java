package com.xyzws.tempconverter;

import java.rmi.RemoteException;

/**
 * Created by duongtq on 26/09/2014.
 */
public interface ConverterIF {
    public double cToF(double celsius) throws RemoteException;

    public double fToC(double fahrenheit) throws RemoteException;
}
