package java.scjp6.exams.practice.dump;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static class A {
        void process() throws Exception {
            throw new Exception();
        }
    }

    static class B extends A {
        void process() {
            System.out.println("B");
        }
    }

    static class C extends B {

    }

    public static void main(String[] args) {
        Long tail = 2000L;
        Long head = 2000L;
        Long distance = 1999L;
        Long story = 1000L;
        System.out.println(tail > distance);
        System.out.println((story * 2) == tail);
        System.out.println(head != tail);
        List l = new ArrayList();
        A a = new C();
        if (a instanceof A) System.out.println("a is O");
        ;
    }

    public static void foo(List<Object> l) {
    }
}

interface All1 {
    String s = null;
}

enum Element {
    EARTH, WIND,
    FIRE {
        public String info() {
            return "Hot";
        }
    };

    public String info() {
        return "element";
    }
}

enum CARD {
    ACE("A"), KING("K"), QUEEN("Q");

    private String name;

    CARD(String name) {
        this.name = name;
    }
}
