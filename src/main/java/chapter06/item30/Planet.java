package java.chapter06.item30;

/**
 * Created by somallg on 8/23/14.
 */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.976e+24, 6.378e6),
    MARS(5.976e+24, 6.378e6),
    JUPITER(5.976e+24, 6.378e6),
    SATURN(5.976e+24, 6.378e6),
    URANUS(5.976e+24, 6.378e6),
    NEPTUNE(5.976e+24, 6.378e6),
    SUN(5.976e+24, 6.378e6);

    private final double mass;
    private final double radius;
    private final double surface;

    private static final double G = 6.67300E-11;


    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surface = G * mass / (radius * radius);
    }

    public double mass() { return mass; }
    public double radius() { return radius; }
    public double surface() { return surface;}

    public double surfaceWeight(double mass) {
        return mass * surface;
    }

    public static void main(String[] args) {
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(10));
        }

        System.out.println(Planet.SUN.ordinal());
    }
}
