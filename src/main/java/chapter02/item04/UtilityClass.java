package java.chapter02.item04;

/**
 * Created by DuongTQ on 8/5/2014.
 */

// Non-instantiable utility class
public class UtilityClass {
    // Suppress default constructor for non-instantiability
    private UtilityClass() {
        throw new AssertionError();
    }
}
