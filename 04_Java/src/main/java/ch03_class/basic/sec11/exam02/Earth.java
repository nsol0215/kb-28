package main.java.ch03_class.basic.sec11.exam02;

public class Earth {
    static final double EARTH_RADIUS = 6400;

    static final double EARTH_SURFASE_AREA;

    static {
        EARTH_SURFASE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }
}
