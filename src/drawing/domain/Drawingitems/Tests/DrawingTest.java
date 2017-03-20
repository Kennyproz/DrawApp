package drawing.domain.Drawingitems.Tests;

import drawing.domain.Drawingitems.Drawing;
import drawing.domain.Drawingitems.Oval;
import drawing.domain.Enums.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ken on 14-3-2017.
 */
class DrawingTest {

    Drawing drawing ;


    @org.junit.jupiter.api.Test
    void getItems() {
        drawing = new Drawing();
        drawing.addDrawing(new Oval(Color.BLACK));
        assertEquals(drawing.getItems().size(), 1);
    }

    @org.junit.jupiter.api.Test
    void addDrawing() {
        drawing = new Drawing();
        assertEquals(drawing.getItems().size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeDrawing() {
        drawing = new Drawing();
        Oval oval = new Oval(Color.BLACK);
        Oval ovalOne = new Oval(Color.GREEN);
        drawing.addDrawing(oval);
        drawing.addDrawing(ovalOne);
        assertEquals(drawing.getItems().size(), 2);
        drawing.removeDrawing(oval);
        assertEquals(drawing.getItems().size(), 1);
        drawing.removeDrawing(ovalOne);
        assertEquals(drawing.getItems().size(), 0);
    }

}