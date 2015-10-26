package java.scjp6.exams.practice.collectionsdemo;

import java.util.*;

public class HashSetDemo {

    public static void main(String[] args) {
        Set s = new HashSet();
        s.add("A");
        s.add("B");
        s.add(1);

        // 1 - Iterator
        Iterator i = s.iterator();
        while (i.hasNext()) {
            System.out.print(i.next());
//			i.remove();
        }
    }

}
