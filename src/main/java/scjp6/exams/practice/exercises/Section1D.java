package java.scjp6.exams.practice.exercises;

public class Section1D {
    class A {
        A() {
            System.out.println("super");
        }
    }

    int i;
    static int j;

    static {
        System.out.println("static init");
        j = 10;
    }

    {
        System.out.println("non static init");
        this.i = 10;
    }

    Section1D() {
        System.out.println("constructor init");
    }

    public static void main(String[] args) {
        Section1D s = new Section1D();
    }
}
