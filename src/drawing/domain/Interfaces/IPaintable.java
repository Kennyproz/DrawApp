package drawing.domain.Interfaces;

import drawing.domain.Image;
import drawing.domain.Oval;
import drawing.domain.PaintedText;
import drawing.domain.Polygon;

import java.awt.*;

/**
 * Created by Ken
 */
public interface IPaintable {

    void paint(Oval oval);
    void paint(Polygon polygon);
    void paint (PaintedText text);
    void paint (Image image);

}
