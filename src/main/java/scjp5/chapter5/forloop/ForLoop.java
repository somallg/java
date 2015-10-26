package java.scjp5.chapter5.forloop;

public class ForLoop {

    public static void main(String[] args) {
        // basic for loop
        for (int i = 0; i < 5; ++i) {
            if (i == 0) {
                continue;
            }
            System.out.println(i);
        }

        // enhanced for loop
        int[] a = {10, 20, 30};
        loop:
        for (long i : a) {
            System.out.println(i);
            label:
            if (i == 10) {
                continue loop;
            }
        }
    }

}
