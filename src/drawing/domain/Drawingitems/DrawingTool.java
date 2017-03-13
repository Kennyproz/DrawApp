package drawing.domain.Drawingitems;

import drawing.domain.DatabaseMediator;
import drawing.domain.Enums.Color;
import drawing.domain.JavaFXPaintable;
import drawing.domain.Point;
import drawing.domain.SerializationMediator;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ken
 */
public class DrawingTool extends javafx.application.Application{

    private SerializationMediator sm = new SerializationMediator();
    private DatabaseMediator dm = new DatabaseMediator();

    private JavaFXPaintable paintable;
    private Drawing drawing;


    public static void drawingTool(String[] args) {
        launch(args);
    }

    public DrawingTool() throws IOException {
    }

    /**
     * Constructor for drawingtool
     * @param drawing
     * @param javaFXPaintable
     */
    public DrawingTool(Drawing drawing, JavaFXPaintable javaFXPaintable) throws IOException {
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
        System.out.println("Ken's Drawing application");
        Group root = new Group();

        Drawing drawing = new Drawing();
        Canvas canvas = new Canvas(700,700);

        sm = new SerializationMediator();
        dm = new DatabaseMediator();

        //Point paintedtextPoint = new Point(160,40);
        //PaintedText paintedText = new PaintedText(Color.BLACK,"Lorum Ipsum test","Arial",paintedtextPoint,100,100);

/*        Point ovalPoint = new Point(20,20);
        Oval oval = new Oval(Color.BLACK,ovalPoint,50,50,40);

        Point imagePoint = new Point(15,200);

        File file = new File("C:\\Users\\Ken\\Google Drive\\Escuela\\S3\\SM-TE3\\Afbeeldingen\\aahappy.png");
        Image image = new Image(Color.BLACK, file, imagePoint,100,100);

        ArrayList<Point> polyPoints = new ArrayList<>();

        polyPoints.add(new Point(10,85));
        polyPoints.add(new Point(85,75));
        polyPoints.add(new Point(110,10));
        polyPoints.add(new Point(135,75));
        polyPoints.add(new Point(210,85));
        polyPoints.add(new Point(160,125));
        polyPoints.add(new Point(170,190));
        polyPoints.add(new Point(110,150));
        polyPoints.add(new Point(50,190));
        polyPoints.add(new Point(60,125));

        Polygon polygon = new Polygon(Color.BLACK,200,polyPoints);

        drawing.addDrawing(image);
        drawing.addDrawing(polygon);
        drawing.addDrawing(oval);
        drawing.addDrawing(paintedText);

        for(DrawingItem item : drawing.items){
            System.out.println(item);
            // Collections.sort(drawing.items, new DrawingItemComparator());
        }*/

        DrawingTool dt = new DrawingTool(drawing, new JavaFXPaintable(canvas.getGraphicsContext2D()));
       // drawing.setName("D1");



/*        try{
           dt.drawing =  sm.load("DTest");
        }
        catch (Exception ex){
           ex.printStackTrace();
        }*/
        try{
           dt.drawing = dm.load("D1");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

      //  dt.drawing.setName("D2");
      //  Point paintedtextPoint = new Point(370,60);
      //  PaintedText paintedText = new PaintedText(Color.BLACK,"Opgehaald database","Arial",paintedtextPoint,100,100);

        //dt.drawing.addDrawing(paintedText);
       // dt.drawing.setName("D1");
        dt.draw();


       // sm.save(drawing);
       // dm.save(drawing);
        root.getChildren().add(canvas);
        primaryStage.setTitle("DrawApp");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
