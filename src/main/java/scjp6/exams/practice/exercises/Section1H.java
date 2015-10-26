package java.scjp6.exams.practice.exercises;

public class Section1H {
    int i = 10;
    static int j = 11;

    static class A {
        void abc() {
            System.out.println(j);
        }
    }

    void abc() {
        class B {
            void abc() {
                System.out.println(i);
            }
        }
        B b = new B();
        b.abc();
    }

    A doABC() {
        A a = new A();
        a.abc();
        return a;
    }

    public static void main(String[] args) {
        Section1H s = new Section1H();
        s.abc();
        s.doABC();
    }
}
