package java.scjp6.exams.practice.dump;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        d.setTime(0); // set time in milliseconds
        DateFormat df = null;
        // 1 return date formatter
        df = DateFormat.getDateInstance();

        // 2 return date/time formatter
        df = DateFormat.getDateTimeInstance();

        // 3 return date/time formatter
        df = DateFormat.getInstance();

        // 4 return time formatter
        df = DateFormat.getTimeInstance();

        df.format(null); // format an Object to a String

        // return a Date parsed from String
        d = df.parse(null); // throws checked ParseException

    }
}
