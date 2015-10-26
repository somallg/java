package java.scjp5.chapter4.instanceoftest;

class Dog {

}

class Golden extends Dog {

}

class Cat {

}

public class Instanceof {

    public static void main(String[] args) {
        String s = "abc";
        Long l = new Long("10");
        Integer i = new Integer("10");

        if (i instanceof Object) {
            System.out.println("instanceof");
        }

        Cat c = new Cat();

        // Compile error
/*		if (c instanceof Dog) {
            System.out.println("Cat is a Dog");
		}*/

        Cat c2 = null;
        if (null instanceof Dog) {
            System.out.println("C2 is a Dog");
        }

        Golden[] d = new Golden[10];
        if (d instanceof Dog[]) {
            System.out.println("OK");
        }


        int players = 0;
        System.out.println("ABC" + players++ + players++);

        boolean b = true;
        System.out.println((b = true) ? "1==0" : "1!=0");

    }

}
