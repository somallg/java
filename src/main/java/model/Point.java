package java.model;

import net.jcip.annotations.ThreadSafe;

/**
 * Created by somallg on 9/2/14.
 */
@ThreadSafe
public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
