package java.scjp6.exams.practice.dump;

import java.util.*;

/**
 * Created by somallg on 5/3/2014.
 */
public class Quest {
    public static void main(String[] args) {
        String[] colors = { "blue", "red", "green", "yello", "orange"};
        Arrays.sort(colors);
        System.out.println(Arrays.asList(colors));
        System.out.println(Arrays.binarySearch(colors, "violiet"));
    }
}
