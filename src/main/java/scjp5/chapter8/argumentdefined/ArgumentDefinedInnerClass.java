package java.scjp5.chapter8.argumentdefined;

public class ArgumentDefinedInnerClass {

    public static void main(String[] args) {
        Bar b = new Bar();
        b.doStuff(new Foo() {

            @Override
            public void foo() {
                System.out.println("Argument defined");
            }

        });
    }

}

interface Foo {
    void foo();
}

class Bar {
    void doStuff(Foo f) {
        f.foo();
    }
}
