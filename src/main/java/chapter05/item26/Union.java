package java.chapter05.item26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by somallg on 8/22/14.
 */
public class Union {

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);

        return result;
    }

    public static <E> void print1(List<E> list) {
        for (E e : list) {
            System.out.println(e + " " + e.getClass());
        }
    }

    public static void print2(List<?> list) {
        print1(list);
    }

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<Integer>();
        Set<Double> doubles = new HashSet<Double>();
        Set<Number> numbers = Union.<Number>union(integers, doubles);

        List<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

        print2(strings);
        print2(integerList);


    }
}
