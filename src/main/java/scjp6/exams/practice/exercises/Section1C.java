package java.scjp6.exams.practice.exercises;

public class Section1C {
    class A {
        A() {
            System.out.println("A");
        }
    }

    class B extends A {
        B() {
            System.out.println("B");
        }
    }

    class C extends B {
        C() {
            System.out.println("C");
        }
    }

    C createC() {
        return new C();
    }

    public static void main(String[] args) {
        new Section1C().createC();
    }
}
