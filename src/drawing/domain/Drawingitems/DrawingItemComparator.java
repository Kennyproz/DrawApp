package drawing.domain.Drawingitems;

import drawing.domain.Point;

import java.util.Comparator;

/**
 * Created by Ken
 * Source https://www.tutorialspoint.com/java/java_using_comparator.htm
 */
public class DrawingItemComparator implements Comparator<DrawingItem> {

    @Override
    public int compare(DrawingItem itemOne, DrawingItem  itemTwo){
        Point pointOne = itemOne.getAnchor();
        Point pointTwo = itemTwo.getAnchor();

        if (pointOne.getX() > pointTwo.getX()){
            return  1;
        }
        else if (pointOne.getX() - pointTwo.getX() < 0.1){
            return 0;
        }
        else {
            return -1;
        }
    }
}
