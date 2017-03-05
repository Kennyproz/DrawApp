package drawing.domain;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 * Created by Ken
 */
public class DrawingTool extends javafx.application.Application{
    private JavaFXPaintable paintable;
    private Drawing drawing;

    /**
     * Constructor for drawingtool
     * @param drawing
     * @param javaFXPaintable
     */
    public DrawingTool(Drawing drawing, JavaFXPaintable javaFXPaintable) {
        this.drawing = drawing;
        this.paintable = javaFXPaintable;
    }

    public void draw(){
        drawing.paintUsing(paintable);
    }

    /**
     * Get JavaFXPaintable for drawingtool
     * @return
     */
    public JavaFXPaintable getPaintable() {
        return paintable;
    }

    /**
     * Set JavaFXPaintable for drawingtool
     * @param paintable
     */
    public void setPaintable(JavaFXPaintable paintable) {
        this.paintable = paintable;
    }

    /**
     * Get drawing for drawingtool
     * @return
     */
    public Drawing getDrawing() {
        return drawing;
    }

    /**
     * Set drawing for drawingtool
     * @param drawing
     */
    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
