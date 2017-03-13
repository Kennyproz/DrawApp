package drawing.domain.Interfaces;

import drawing.domain.Drawingitems.Image;
import drawing.domain.Drawingitems.Oval;
import drawing.domain.Drawingitems.PaintedText;
import drawing.domain.Drawingitems.Polygon;

/**
 * Created by Ken
 */
public interface IPaintable {

    void paint(Oval oval);
    void paint(Polygon polygon);
    void paint (PaintedText text);
    void paint (Image image);

}
