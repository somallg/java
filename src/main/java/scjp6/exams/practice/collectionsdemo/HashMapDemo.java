package java.scjp6.exams.practice.collectionsdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("A", 10); // add element to hashmap
        hm.put("B", 20);
        hm.put("C", 30);
        hm.put("D", 40);
        hm.put("D", 40);
        System.out.println(hm.size()); // size of hash map

        // iterate through hash map
        // 1 - use iterator
        Iterator i = hm.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry p = (Map.Entry) i.next();
            System.out.print(p.getKey() + " = " + p.getValue());
        }

        // 2 - foreach on entrySet()
        System.out.println();
        for (Map.Entry p : hm.entrySet())
            System.out.print(p.getKey() + " = " + p.getValue());

        // 3 - foreach on keySet()
        System.out.println();
        System.out.println(hm.values());
        for (String k : hm.keySet())
            System.out.print(k + " = " + hm.get(k));

        hm.clear(); // remove all elements
        System.out.println("hm size = " + hm.size()); // size of hash map
    }

}
