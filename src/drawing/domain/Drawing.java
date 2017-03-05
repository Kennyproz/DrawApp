package drawing.domain;

import drawing.domain.Interfaces.IPaintable;

import java.util.ArrayList;

/**
 * Created by Ken
 */
public class Drawing {

    private String name;
    public ArrayList<DrawingItem> items;

    /**
     * Constructor for drawing
     */
    public Drawing() {
        items = new ArrayList<>();
    }

    /**
     * Get drawingitems for drawing
     * @return
     */
    public ArrayList<DrawingItem> getItems() {
        return items;
    }

    /**
     * Set item for drawing
     * @param items
     */
    public void setItems(ArrayList<DrawingItem> items) {
        this.items = items;
    }

    /**
     * Get name for drawing
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for drawing
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean addDrawing(DrawingItem item){
        return items.add(item);
    }
    public boolean editDrawing(DrawingItem oldItem, DrawingItem newItem){
        newItem.previousState = oldItem;
        return true;
    }
    public boolean removeDrawing(DrawingItem item){
         return items.remove(item);
    }

    public void paintUsing(IPaintable paintable){
        for (DrawingItem item : items){
            item.paintUsing(paintable);
        }
    }
}
