package java.chapter02.item03.approach02;

/**
 * Created by DuongTQ on 8/5/2014.
 */

// Singleton with static factory
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
    }
}
