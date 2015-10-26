package java.chapter10;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Set;

/**
 * Created by duongtq on 04/09/2014.
 */
@ThreadSafe
public class Dispatcher {
    @GuardedBy("this")
    private final Set<Taxi> taxis;

    @GuardedBy("this")
    private final Set<Taxi> availableTaxis;


    public Dispatcher(Set<Taxi> taxis, Set<Taxi> availableTaxis) {
        this.taxis = taxis;
        this.availableTaxis = availableTaxis;
    }

    public synchronized void notifyAvailable(Taxi taxi) {
        availableTaxis.add(taxi);
    }
}
