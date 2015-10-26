package java.scjp6.exams.practice.collectionsdemo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        lhm.put("A", 10); // add element to hashmap
        lhm.put("B", 20);
        lhm.put("C", 30);
        lhm.put("D", 40);
        lhm.put("D", 40);
        System.out.println(lhm.size()); // size of hash map

        // iterate through hash map
        // 1 - use iterator
        Iterator i = lhm.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry p = (Map.Entry) i.next();
            System.out.print(p.getKey() + " = " + p.getValue());
        }

        // 2 - foreach on entrySet()
        System.out.println();
        for (Map.Entry p : lhm.entrySet())
            System.out.print(p.getKey() + " = " + p.getValue());

        // 3 - foreach on keySet()
        System.out.println();
        System.out.println(lhm.values());
        for (String k : lhm.keySet())
            System.out.print(k + " = " + lhm.get(k));

        lhm.clear(); // remove all elements
        System.out.println("hm size = " + lhm.size()); // size of hash map
    }

}
