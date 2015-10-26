package java.scjp5.chapter4.bitwiseoperators;

public class BitWiseOperators {

    public static void main(String[] args) {
        boolean t = true;
        boolean f = false;


        System.out.println("Bitwise operator &");
        System.out.println(t & t);
        System.out.println(t & f);
        System.out.println(f & f);
        System.out.println();

        System.out.println("Bitwise operator |");
        System.out.println(t | t);
        System.out.println(t | f);
        System.out.println(f | f);
        System.out.println();

        System.out.println("Bitwise operator ^");
        System.out.println(t ^ t);
        System.out.println(t ^ f);
        System.out.println(f ^ f);
        System.out.println();
    }

}
