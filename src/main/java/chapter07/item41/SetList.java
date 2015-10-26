package java.chapter07.item41;

import java.util.*;

/**
 * Created by duongtq on 8/25/14.
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove((Integer)i);
        }

        System.out.println(set + " " + list);

        int[] digits = { 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(digits));
    }


}
