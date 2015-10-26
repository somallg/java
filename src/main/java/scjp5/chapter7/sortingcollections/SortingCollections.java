package java.scjp5.chapter7.sortingcollections;

import java.util.*;

public class SortingCollections {

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("A");
        l.add("BC");
        l.add("C");
        Collections.sort(l);

        long[] a = new long[3];
        a[0] = 3L;
        a[1] = 2L;
        a[2] = 1L;
        for (Long ele : a) {
            System.out.println(ele + " ");
        }
        System.out.println();
        Arrays.sort(a);
        for (Long ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

}

class LongComp implements Comparator<Long> {

    @Override
    public int compare(Long arg0, Long arg1) {
        return (int) (arg1 - arg0);
    }

}

class A implements Comparable<A> {

    @Override
    public int compareTo(A o) {
        return 0;
    }

}