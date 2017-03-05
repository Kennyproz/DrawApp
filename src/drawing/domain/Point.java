package drawing.domain;

/**
 * Created by Ken
 */
public class Point {
    public double getX() {
        return x;
    }

    private double x;

    public double getY() {
        return y;
    }

    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
