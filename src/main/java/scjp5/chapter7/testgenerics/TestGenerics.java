package java.scjp5.chapter7.testgenerics;

import java.util.*;

public class TestGenerics<T> {
    // T anInstance;
    // T[] array;

    public TestGenerics(T anInstance) {
    }

    // public T getT() {
    // return anInstance;
    // }

    List<? extends Animal> bar() {
        return null;
    }

    public static void main(String[] args) {
        int x = 8;
        int y = 3;
        System.out.printf("%f + %f \n", y, x);

        List<? extends Animal> l2;
        List<Dog> l = new ArrayList<Dog>();
        Map<String, String> m = new HashMap<String, String>();
        m.put("A", "A");
        m.put("A", "Z");
        System.out.println(m.get("A"));
        int[] a = new int[100];
        System.out.println(a.length);
        // List<String> x = new LinkedList<String>();
        // x.add("ABC");
        List<Integer> input = null;
        List<Integer> output = null;
        output = process(input);
    }

    public static <E extends Number> List<E> process(List<E> nums) {
        return nums;
    }
}

class GenericUtily {
    public static <E extends CharSequence> Collection<? extends CharSequence> getLongWords(
            Collection<E> coll) {
        Collection<E> longword = new ArrayList<E>();
        return longword;
    }
}