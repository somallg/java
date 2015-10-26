package java.chapter07.item41;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by duongtq on 8/25/14.
 */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
       return "Set";
    }

    public static String classify(List<?> l) {
        return "List";
    }

    public static String classify(Collection<?> l) {
       return "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.printf(classify((Set<?>)c));
        }
    }
}
