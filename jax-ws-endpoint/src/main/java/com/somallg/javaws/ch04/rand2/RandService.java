package com.somallg.javaws.ch04.rand2;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface RandService {

    @WebMethod
    public int next1();

    @WebMethod
    public int[] nextN(final int n);

}
