package java.scjp6.exams.practice.dump;

import java.util.TreeSet;

/**
 * Created by somallg on 5/4/2014.
 */

class A {
    String name = "A";

    String getName() {
        return name;
    }

    String greeting() {
        return "class A";
    }

    private final void foo() {
    }
}

class B extends A {
    String name = "B";

    String greeting() {
        return "class B";
    }

    void foo() {
    }
}

public class Client {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        System.out.println(a.greeting() + " has name " + a.getName());
        System.out.println(b.greeting() + " has name " + b.getName());
        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();
        for (int i = 606; i < 613; i++)
            if (i % 2 == 0) s.add(i);

        subs = (TreeSet) s.subSet(608, true, 611, true);
        //subs.add(629);
        System.out.println(s + " " + subs);
    }

}
