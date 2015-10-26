package java.scjp6.exams.practice.dump;

/**
 * Created by somallg on 5/3/2014.
 */

interface Pet { }
class Cat implements Pet { }
public class GenericB <T extends Pet> {
    private T foo;

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public T getFoo() { return foo; }

    public static void main(String[] args) {
        GenericB<Cat> bar = new GenericB<Cat>();
        bar.setFoo(new Cat());
        Cat c = bar.getFoo();
    }
}
