package java.scjp6.exams.practice.dump;

/**
 * Created by somallg on 5/4/14.
 */
public class Egg<E extends Object> {
    E egg;

    public Egg(E egg) {
        this.egg = egg;
    }

    public E getEgg() {
        return egg;
    }

    public static void main(String[] args) {
        Egg<Egg> e1 = new Egg(42);
        Egg e2 = new Egg<Egg>(e1.getEgg());
        Egg e3 = e1.getEgg();
    }

}
