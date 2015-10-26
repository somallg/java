package java.chapter02.item03.approach01;

/**
 * Created by DuongTQ on 8/5/2014.
 */

// Singleton with public final field
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
    }
}
