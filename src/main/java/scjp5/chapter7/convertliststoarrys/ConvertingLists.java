package java.scjp5.chapter7.convertliststoarrys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConvertingLists {

    public static void main(String[] args) {
        String[] a = new String[3];
        a[0] = "A";
        a[1] = "B";
        a[2] = "C";
        List l = Arrays.asList(a);
        l.set(0, "Z");

        int[] ai = new int[3];
        ai[0] = 1;
        ai[1] = 2;
        ai[2] = 3;
        List Li = Arrays.asList(ai);
        Iterator liter = Li.iterator();
        System.out.println(Li.get(0));
        while (liter.hasNext()) {
            System.out.println(liter.next());
        }
        System.out.println();

        System.out.println(a[0]);

        List<String> l2 = new ArrayList<String>();
        l2.add("D");
        l2.add("E");
        l2.add("F");

        Iterator iter = l2.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

        for (int i = 0; i < l2.size(); ++i) {
            System.out.print(l2.get(i) + " ");
        }
        System.out.println();


        String[] a2 = new String[3];
        a2 = l2.toArray(a2);
        a2[0] = "Z";
        System.out.println(a2[0]);
        System.out.println(l2.get(0));

    }

}
