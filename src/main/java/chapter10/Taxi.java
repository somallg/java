package java.chapter10;

import model.Point;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by duongtq on 04/09/2014.
 */
@ThreadSafe
public class Taxi {
    @GuardedBy("this")
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation() {
        return location;
    }

    public synchronized void setLocation(Point location) {
        boolean reachedDestination;

        synchronized (this) {
            this.location = location;
            reachedDestination = location.equals(destination);
            if (reachedDestination)
                dispatcher.notifyAvailable(this);
        }
    }
}
