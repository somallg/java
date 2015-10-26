package java.scjp5.chapter7.genericmethods;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {
        System.out.print("Hello");
        List<Cat> l = new ArrayList<Cat>();
        add(l);
        System.out.println(l.get(0));
    }

    public static void add(List<? super Cat> l) {
        l.add(new Cat());
        //l.add(new Dog());
    }
}


class Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}