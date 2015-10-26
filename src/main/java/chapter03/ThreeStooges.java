package java.chapter03;

import net.jcip.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by somallg on 9/1/14.
 */
@Immutable
public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStoogle(String name) {
        return stooges.contains(name);
    }
}
