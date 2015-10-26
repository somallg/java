package java.ocpjp7.exams.practice;

/**
 * Created by somallg on 5/10/14.
 */
public class NullInstanceof {
    public static void main(String[] args) {
        String s = null;
        if (s instanceof Object)
            System.out.println("ok");
        else
            System.out.println("not ok");
    }
}
