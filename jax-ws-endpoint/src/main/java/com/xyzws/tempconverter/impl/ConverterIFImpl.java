package com.xyzws.tempconverter.impl;

import com.xyzws.tempconverter.ConverterIF;

import java.rmi.RemoteException;

/**
 * Created by duongtq on 26/09/2014.
 */
public class ConverterIFImpl implements ConverterIF {
    @Override
    public double cToF(double celsius) throws RemoteException {
        return celsius / 5 * 9 + 32;
    }

    @Override
    public double fToC(double fahrenheit) throws RemoteException {
        return (fahrenheit - 32) / 9 * 5;
    }
}
