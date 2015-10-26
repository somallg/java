package java.chapter08.item51;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by duongtq on 8/26/14.
 */
// Reflective instantiation with interface access
public class Reflection {
    public static void main(String[] args) {
        // Translate the class name into a Class object
        Class<?> cl = null;

        try {
            cl = Class.forName("java.util.HashSet");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found.");
            System.exit(1);
        }

        // Instantiate the class
        Set<String> s = null;
        try {
            s = (Set<String>) cl.newInstance();
        } catch (InstantiationException e) {
            System.err.println("Class not instantiable");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.err.println("Class not accessible");
            System.exit(1);
        }

        // Exercise the set
        s.addAll(Arrays.asList("D", "C", "B", "A"));
        System.out.println(s);

    }
}
