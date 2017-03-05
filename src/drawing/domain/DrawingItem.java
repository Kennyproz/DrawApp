package drawing.domain;

import drawing.domain.Interfaces.IPaintable;

import java.util.Comparator;

/**
 * Created by Ken
 */
public abstract class DrawingItem implements Comparator<DrawingItem>{

    private Color color;
    protected DrawingItem previousState;
    protected abstract Point getAnchor();
    protected abstract double getWidth();
    protected abstract double getHeight();

    /**
     * Get drawingitem color
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     *  Set drawingitem color
     * @param previousState
     * @param color
     */
    public void setColor(DrawingItem previousState, Color color) {
        this.previousState = previousState;
        this.color = color;
    }

    /**
     * Constructor for drawingitem
     * @param color
     */
    public DrawingItem(Color color) {
        this.color = color;
    }

    /**
     * Set drawingitem previousstate
     * @param previousState
     */
    public void setPreviousState(DrawingItem previousState) {
        this.previousState = previousState;
    }

    /**
     * Set drawingitem previousstate
     */
    public void setPreviousState(){
        previousState = this;
    }

    public abstract void paintUsing(IPaintable paintable);

    @Override
    public String toString() {
        return this.getColor().toString();
    }

}
