package java.scjp6.exams.practice.exercises;

public class Section2B {
    enum E {
        A, B, C, D
    }


    public static void main(String arg[]) {
        E i = E.A;
        System.out.println(i.compareTo(E.B)); // Compare 2 Enums
        System.out.println(i.equals(E.B));    // check for equality
        System.out.println(i.equals(E.A));    // check for equality
        System.out.println("class = " + i.getDeclaringClass());    // get declaring class
        System.out.println("hashcode = " + i.hashCode());     // hash code
        System.out.println("name = " + i.name());         // return the name of Enum
        System.out.println("ordinal = " + i.ordinal());         // return the ordinal of Enum (position of the Enum in its declaration)
        System.out.println("toString = " + i.toString());
        System.out.println("valueOf = " + E.valueOf("A"));

        for (E j : E.values()) {

            switch (j) {
                case A:
                    System.out.println('A');
                    break;
                case B:
                    System.out.println('B');
                    break;
                case C:
                    System.out.println('C');
                    break;
                default:
                    System.out.println('D');
                    break;
            }
        }
    }
}

