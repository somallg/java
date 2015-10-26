package java.scjp6.exams.practice.exercises;

public class Section3A {
    public static void main(String[] args) {
        Integer i = new Integer(10);
        double d = i.doubleValue(); // Wrapper to primitive
        int j = Integer.parseInt("10"); // String to primitive
        int j2 = Integer.parseInt("10", 2); // String to primitive
        Integer o1 = Integer.valueOf(10);       // from int, or String to Wrapper object
        Integer o2 = Integer.valueOf("10");
        Integer o3 = Integer.valueOf("10", 2);
        System.out.println(j2);
    }
}
