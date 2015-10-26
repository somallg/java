package java.chapter04;

import net.jcip.annotations.GuardedBy;

/**
 * Created by somallg on 9/2/14.
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    Object widget;

    void someMethid() {
        synchronized (myLock) {

        }
    }
}
