package java.chapter01;

import net.jcip.annotations.NotThreadSafe;

/**
 * Created by duongtq on 30/08/2014.
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Return a unique value.
     */
    public int getNext() {
        return value++;
    }
}
