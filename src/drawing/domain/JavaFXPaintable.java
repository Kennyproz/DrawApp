package drawing.domain;

import drawing.domain.Drawingitems.Image;
import drawing.domain.Drawingitems.Oval;
import drawing.domain.Drawingitems.PaintedText;
import drawing.domain.Drawingitems.Polygon;
import drawing.domain.Interfaces.IPaintable;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Ken
 * Source polygon drawing http://zetcode.com/gui/javafx/canvas/
 */
public class JavaFXPaintable implements IPaintable {

    GraphicsContext graphicsContext;

    /**
     * Get graphicscontext for JavaFXPaintable
     * @return
     */
    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    /**
     * Set graphicscontext for JavaFXPaintable
     * @param graphicsContext
     */
    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void paint(Oval oval) {
        graphicsContext.strokeOval(oval.getAnchor().getX(),oval.getAnchor().getY(),oval.getWeight(),oval.getHeight());
    }

    @Override
    public void paint(Polygon polygon) {
        int count = 0;

        double[] xPoints = new double [polygon.getVerticles().size()];
        double[] yPoints = new double [polygon.getVerticles().size()];

        for (Point point : polygon.getVerticles()){
            xPoints[count] = point.getX();
            yPoints[count] = point.getY();
            count++;
         }
        graphicsContext.strokePolygon(xPoints,yPoints,polygon.getVerticles().size());
    }

    @Override
    public void paint(PaintedText text) {
        graphicsContext.strokeText(text.getContent(),text.getAnchor().getX(),text.getAnchor().getY(),text.getWidth());
    }

    @Override
    public void paint(Image image) {
        javafx.scene.image.Image img = new javafx.scene.image.Image(image.getFile().toURI().toString());
        graphicsContext.drawImage(img,image.getAnchor().getX(),image.getAnchor().getY());
    }

    public JavaFXPaintable(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}
