package java.scjp5.chapter4.equality;

class Car {

}

class Honda extends Car {

}

public class Equality {

    public static void main(String[] args) {
        int i = 1;
        boolean t = true;
        Long l = 10L;
        String s = new String("abc");
        Honda h = new Honda();
        Car c = new Car();
        System.out.println(h == new Object());
        System.out.println(5.0f == 5L);
        System.out.println(l == 5.0f);
        boolean b = true;
        if (b = false) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(5 + 2 * 2 + 2);

    }

}
