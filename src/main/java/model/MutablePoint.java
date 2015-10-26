package java.model;

import net.jcip.annotations.NotThreadSafe;

/**
 * Created by somallg on 9/2/14.
 */
@NotThreadSafe
public class MutablePoint {
    private int x;
    private int y;

    public MutablePoint(MutablePoint loc) {
        this.x = loc.x;
        this.y = loc.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
