package java.scjp6.exams.practice.dump;

public class FormatDemo {

    public static void main(String[] args) {
        System.out.format("%b", "abc");

        // IllegalFormatConversionException: d != Boolean
        //System.out.format("%d", true);

    }

}
