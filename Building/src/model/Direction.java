package model;

/**
 * This class provides static constants and methods useful for dealing
 * with directions.
 */
public class Direction {
    public static final int UP = 1;
    public static final int DOWN = -1;
    public static final int STATIONARY = 0;

    /**
     * Returns the direction from 'from' to 'to'.
     */
    public static int fromTo(int from, int to) {
        return Integer.compare(to, from);
    }
}
