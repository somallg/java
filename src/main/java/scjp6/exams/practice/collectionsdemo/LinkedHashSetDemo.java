package java.scjp6.exams.practice.collectionsdemo;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String... args) {
        LinkedHashSet s = new LinkedHashSet();
        s.add("123");
        s.add(1);
        s.add(2);
        s.add(3);

        for (Object o : s)
            System.out.println(o);
    }
}
