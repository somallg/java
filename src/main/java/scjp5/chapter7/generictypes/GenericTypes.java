package java.scjp5.chapter7.generictypes;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        insert(myList);

        for (Object o : myList) {
            System.out.println(o);
        }
    }

    public static void insert(List list) {
        list.add(new String("ABC"));
    }

}
