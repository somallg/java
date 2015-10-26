package java.chapter03;

import net.jcip.annotations.NotThreadSafe;

/**
 * Created by somallg on 9/1/14.
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get() { return value; }

    public void set(int value) { this.value = value; }
}
