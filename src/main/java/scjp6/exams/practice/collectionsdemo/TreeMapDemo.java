package java.scjp6.exams.practice.collectionsdemo;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> hm = new TreeMap<String, Integer>();
        hm.put("D", 40);
        hm.put("C", 30);
        hm.put("B", 20);
        hm.put("A", 10); // add element to hashmap
        hm.put("D", 40);
        System.out.println(hm.size()); // size of hash map
        //Collections.sort(hm);	// Error

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
