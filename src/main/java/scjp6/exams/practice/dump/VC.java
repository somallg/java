package java.scjp6.exams.practice.dump;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by somallg on 5/4/14.
 */
public class VC {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<Integer>();
        Integer[] a = {3, 1, 4, 1};
        Integer[] b = {3, 1, 4, 1};
        x = Arrays.asList(a);
        a[3] = 2;
        x.set(0, 7);
        System.out.println(x);
        System.out.println(x);
        Iterator<Integer> i = x.iterator();
    }
}
