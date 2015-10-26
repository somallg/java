package java.scjp6.exams.practice.exercises;

public class Section1A extends MyClass implements MyInterface {
    public static void main(String[] args) {
        Section1A s = new Section1A();
        System.out.print("i = " + s.i);
        System.out.print(" c = " + s.c);
        s.doA();
        s.doB();
    }

    public void doA() {
        System.out.print("A ");
    } // need to be public

    void doB() {
        System.out.print("B ");
    }
}

interface MyInterface {
    int c = 10;

    void doA();
}

abstract class MyClass {

    abstract void doB();

    void doC() {
        System.out.print("C ");
    }

    int i = 11;
}