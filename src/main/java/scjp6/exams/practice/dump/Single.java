package java.scjp6.exams.practice.dump;

/**
 * Created by somallg on 5/3/2014.
 */
public class Single {
    private static Single instance;

    public static Single getInstance() {
        if (instance == null) instance = create();
        return instance;
    }

    protected Single() { }

    static Single create() {
        return new Single();
    }
}

class SingleSub extends Single {
}
