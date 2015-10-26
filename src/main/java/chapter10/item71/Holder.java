package java.chapter10.item71;

import java.io.Serializable;

/**
 * Created by somallg on 8/29/14.
 */
public class Holder {
    // Lazy initialization holder class idiom for static fields
    private static class FieldHolder {
        static final String field = "ABC";
    }

    static String getField() {
        return FieldHolder.field;
    }

}
