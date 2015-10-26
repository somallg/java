package java.scjp6.exams.practice.dump;

import java.util.Arrays;

/**
 * Created by somallg on 5/2/14.
 */

class Nameable {
    String name;
}

class Animal extends Nameable {

    Animal(String n) {
        name = n;
    }

    String getName() {
        return name;
    }
}

public class Buddies extends Animal {

    public Buddies(String s) {
        super(s);
    }

    public static void main(String[] args) {
        Animal b1 = new Animal("Kara");
        Buddies b2 = new Buddies("Charis");
        System.out.println(b1.getName() + " " + b2.getName());
    }
}
