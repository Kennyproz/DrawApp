package drawing.domain.Drawingitems;

import drawing.domain.Enums.Color;
import drawing.domain.Interfaces.IPaintable;
import drawing.domain.Point;

import java.util.ArrayList;

/**
 * Created by Ken
 */
public class Polygon extends DrawingItem {

    private double weight;
    private ArrayList<Point> verticles;

    /**
     * Constructor for polygon
     * @param color
     */
    public Polygon(Color color) {
        super(color);
    }

    /**
     * Constructor for polygon
     * @param color
     * @param weight
     * @param verticles
     */
    public Polygon(Color color, double weight, ArrayList<Point> verticles) {
        super(color);
        this.weight = weight;
        this.verticles = verticles;
    }

    @Override
    public void paintUsing(IPaintable paintable) {
        paintable.paint(this);
    }

    /**
     * @return weight for polygon
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set weight for polygon
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get verticles for polygon
     * @return
     */
    public ArrayList<Point> getVerticles() {
        return verticles;
    }

    /**
     * @return anchor for polygon
     */
    @Override
    public Point getAnchor() {
        return null;
    }

    /**
     * @return width for polygon
     */
    @Override
    public double getWidth() {
        return 0;
    }

    /**
     * @return height for polygon
     */
    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "weight=" + weight +
                ", verticles=" + verticles +
                '}';
    }
    @Override
    public int compare(DrawingItem itemOne, DrawingItem itemTwo) {
        boolean points = itemOne.getAnchor().equals(itemTwo.getAnchor());
        if (points)
        {
            return 1;
        }
        else {
            return 0;
        }}
}

