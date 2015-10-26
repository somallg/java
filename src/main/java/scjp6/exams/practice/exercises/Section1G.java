package java.scjp6.exams.practice.exercises;

import java.util.ArrayList;
import java.util.List;

public class Section1G {
    class A {
        void a() {
            System.out.println("A");
        }
    }

    class B extends A {
        void a() {
            System.out.println("B");
        }
    }

    class C extends B {
        void a() {
            System.out.println("C");
        }
    }

    public static void main(String args[]) {
        Section1G s = new Section1G();
        A[] a = new A[3];
        a[0] = s.new A();
        a[1] = s.new B();
        a[2] = s.new C();

        for (A i : a) {
            i.a();
        }

        List<A> l = new ArrayList<A>();
        l.add(s.new A());
        l.add(s.new B());
        l.add(s.new C());

        for (A i : l) {
            i.a();
        }
    }
}

