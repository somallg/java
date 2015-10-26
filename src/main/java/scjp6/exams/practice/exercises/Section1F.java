package java.scjp6.exams.practice.exercises;

public class Section1F {
    public static void main(String[] args) {
        E e = E.A;
        System.out.println(e.abc());
        System.out.println(e);
    }
}

enum E {
    A(1), B(2), C(3);

    private int i;

    E(int i) {
        this.i = i;
    }

    int getI() {
        return i;
    }

    String abc() {
        return "abc";
    }
}
