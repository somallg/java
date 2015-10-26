package java.chapter02;

import net.jcip.annotations.NotThreadSafe;

/**
 * Created by somallg on 8/31/14.
 */
@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }

        return instance;
    }
}
