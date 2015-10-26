package java.scjp6.exams.practice.collectionsdemo;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<String> p = new PriorityQueue<String>();
        p.add("Z");
        p.add("X");
        p.add("A");
        p.add("B");

        for (String s : p) {
            System.out.print(s + " ");
        }

        System.out.println();
        Iterator it = p.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
    }

}
