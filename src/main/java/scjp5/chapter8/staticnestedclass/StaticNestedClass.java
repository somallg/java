package java.scjp5.chapter8.staticnestedclass;

public class StaticNestedClass {
    static {
        class Inner3 {
            void go() {
                System.out.println("go3");
            }
        }
    }

    private static class Inner2 {
        void go() {
            System.out.println("go2");
        }
    }

    public static void main(String[] args) {
        Inner2 i2 = new Inner2();
        Outer.Inner i = new Outer.Inner();
        i.go();
        i2.go();
    }

}

class Outer {
    static class Inner {
        void go() {
            System.out.println("Inner class go");
        }
    }
}