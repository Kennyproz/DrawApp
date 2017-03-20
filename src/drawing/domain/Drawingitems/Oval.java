package drawing.domain.Drawingitems;

import drawing.domain.Enums.Color;
import drawing.domain.Interfaces.IPaintable;
import drawing.domain.Point;

/**
 * Created by Ken
 */
public class Oval extends DrawingItem {


    private Point anchor;
    private double width;
    private double height;
    private double weight;

    /**
     * Constructor for oval
     * @param color
     */
    public Oval(Color color) {
        super(color);
    }

    /**
     * Constructor for oval
     * @param color
     * @param anchor
     * @param width
     * @param height
     * @param weight
     */
    public Oval(Color color, Point anchor, double width, double height, double weight) {
        super(color);
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Set height for oval
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Set anchor for oval
     * @param anchor
     */
    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    /**
     * Set width for oval
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * get anchor for oval
     * @return
     */
    @Override
    public Point getAnchor() {
        return anchor;
    }

    /**
     * Get width for oval
     * @return
     */
    @Override
    public double getWidth() {
        return width;
    }

    /**
     * Get height for oval
     * @return
     */
    @Override
    public double getHeight() {
        return height;
    }

    /**
     * Get weight for oval
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set weight for oval
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void paintUsing(IPaintable paintable) {
        paintable.paint(this);
    }

    @Override
    public String toString() {
        return "Oval{" +
                "Color= " + this.getColor().toString() +
                ", weight= " + weight +
                ", anchor= " + anchor +
                ", width= " + width +
                ", height= " + height +
                '}';
    }

}
