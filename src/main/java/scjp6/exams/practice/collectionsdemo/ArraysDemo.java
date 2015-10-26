package java.scjp6.exams.practice.collectionsdemo;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {
        String[] a = new String[4];
        a[0] = "d";
        a[1] = "c";
        a[2] = "b";
        a[3] = "a";

        List<String> l = Arrays.asList(a);
        Arrays.sort(a);

        for (String s : l) {
            System.out.print(s + " ");
        }


    }

}
