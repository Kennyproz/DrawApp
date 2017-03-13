package drawing.domain;

import java.io.Serializable;

/**
 * Created by Ken
 */
public class Point implements Serializable{
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
