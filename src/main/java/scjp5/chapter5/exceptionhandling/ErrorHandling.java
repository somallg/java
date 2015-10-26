package java.scjp5.chapter5.exceptionhandling;

import java.util.Scanner;

public class ErrorHandling {

    public static void main(String[] args) {

        Scanner c = new Scanner(System.in);
        c.close();
        c.nextInt();

        A a = new B();
        B b = ((B) a);
        doABC();
        System.out.println("After doABC()");
    }

    static void doABC() {
        doEDF();
    }

    static void doEDF() {
        try {
            throw new Error();
        } catch (Error e) {
            throw e;
        }
    }

}

class A {

}

class B extends A {

}