package java.scjp5.test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Hello {

    String title;
    int value;

    public Hello() {
        title += "Hello";
    }

    public Hello(int value) {
        this.value = value;
        title += "Hello";
    }

    public enum Dogs {
        a, b, c
    }

    public static Object get0(List l) {
        return l.get(0);
    }

    public static void main(String[] args) {
        Set s = null;
        Collections.sort((List) s);
    }

    public static void go(Long n) {
        System.out.println(" LONG ");
    }
}

interface A {
    void aMethod();
}

interface B {
    void bMethod();
}

interface C extends A, B {
    void cMethod();
}

class D implements B {

    @Override
    public void bMethod() {
        System.out.println("bMethod in D");
    }
}

class E extends D {

    public void aMethod() {
        System.out.println("aMethod in E");
    }

    public void bMethod1() {
        System.out.println("bMethod in E");
    }

    public void cMethod() {
        System.out.println("cMethod in E");
    }

}
