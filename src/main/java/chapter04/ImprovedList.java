package java.chapter04;

import net.jcip.annotations.ThreadSafe;

import java.util.List;

/**
 * Created by somallg on 9/2/14.
 */
@ThreadSafe
public abstract class ImprovedList<T> implements List<T> {
    private final List<T> list;

    protected ImprovedList(List<T> list) {
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x) {
        boolean contains = list.contains(x);
        if (contains)
            list.add(x);

        return !contains;
    }
}
