package java.scjp6.exams.practice.dump;

class Foo {
    public int a;

    public Foo() {
        a = 3;
    }

    public void addFive() {
        a += 5;
    }
}

public class Bar extends Foo {
    public int a;

    public Bar() {
        a = 8;
    }

    public void addFive() {
        a += 5;
    }

    public static void main(String[] args) {
        Foo foo = new Bar();
        foo.addFive();
        System.out.println(foo.a);
        System.out.println(((Bar) foo).a);
    }

}
