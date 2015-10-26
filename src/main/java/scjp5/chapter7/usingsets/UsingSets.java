package java.scjp5.chapter7.usingsets;

import java.util.*;

public class UsingSets {

    public static void main(String[] args) {
        Set s = new HashSet<Integer>();
        System.out.println(s.add(1));
        System.out.println(s.add(2));
        System.out.println(s.add(3));

        Iterator<Integer> iter = s.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println(s.add(3));

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Queue q = new PriorityQueue<Integer>();

    }

}
