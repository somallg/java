package java.scjp6.exams.practice.collectionsdemo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(6);

        // 1 Iterator
        Iterator i = l.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();

        // 2 List iterator
        ListIterator li = l.listIterator();
        while (li.hasNext()) {
            System.out.print(li.next() + " ");
            li.previous();
        }
        System.out.println();
    }

}
