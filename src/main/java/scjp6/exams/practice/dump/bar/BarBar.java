package java.scjp6.exams.practice.dump.bar;

import scjp6.exams.practice.dump.foo.FooFoo;

/**
 * Created by somallg on 5/4/14.
 */
public class BarBar extends FooFoo {
    private enum D {
        A, B, C
    };

    static transient int i;
    static volatile int j;
    public static void main(String[] args) {
        FooFoo f = new FooFoo();
        BarBar b = new BarBar();
        System.out.println(b.i);
    }
    void bar() {
        abc();
        System.out.println(i);
    }
}
