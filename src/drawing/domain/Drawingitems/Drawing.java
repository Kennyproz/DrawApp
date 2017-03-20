package drawing.domain.Drawingitems;

import drawing.domain.Enums.Color;
import drawing.domain.Interfaces.IPaintable;
import drawing.domain.Point;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken
 */
public class Drawing extends DrawingItem implements Serializable {

    private String name;
    private List<DrawingItem> items;
    private ObservableList<DrawingItem> observableList;

    /**
     * Constructor for drawing
     */
    public Drawing() {
        items = new ArrayList<>();
        observableList = FXCollections.observableList(items);
    }

    /**
     * Get drawingitems for drawing
     * @return
     */
    public List<DrawingItem> getItems() {
        return items;
    }

    public ObservableList<DrawingItem> itemsToObserve() {
        return FXCollections.
                unmodifiableObservableList(observableList);
    }

    /**
     * Set item for drawing
     * @param items
     */
    public void setItems(List<DrawingItem> items) {
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
     *
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

    @Override
    protected Point getAnchor() {
        return null;
    }

    @Override
    protected double getWidth() {
        return 0;
    }

    @Override
    protected double getHeight() {
        return 0;
    }

    public void paintUsing(IPaintable paintable){
        for (DrawingItem item : items){
            item.paintUsing(paintable);
        }
    }
}
