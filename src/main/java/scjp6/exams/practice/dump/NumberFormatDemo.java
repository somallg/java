package java.scjp6.exams.practice.dump;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberFormatDemo {

    public static void main(String[] args) throws ParseException {
        NumberFormat nf = null;

        // 1 return a number format
        nf = NumberFormat.getInstance(); // NB is abstract class

        // 2 same as above
        nf = NumberFormat.getNumberInstance();

        nf.format(0); // format to String

        // return Number
        nf.parse(null); // throws checked ParseException
    }

}
