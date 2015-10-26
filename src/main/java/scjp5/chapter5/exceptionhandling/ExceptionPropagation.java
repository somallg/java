package java.scjp5.chapter5.exceptionhandling;

import java.io.IOException;

public class ExceptionPropagation {

    public static void main(String[] args) throws IOException {
        try {
            doABC();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("After doABC()");

    }

    static void doABC() throws IOException {
        doDEF();
    }

    static void doDEF() throws IOException {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw e;
        }
    }

    static void doStuff(int... i) {
        System.out.println(i[0]);
        System.out.println(i[1]);

    }

}