package sample;

import drawing.domain.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        System.out.println("Ken's Drawing application");
        Group root = new Group();

        Drawing drawing = new Drawing();
        Canvas canvas = new Canvas(500,500);

        Point paintedtextPoint = new Point(90,40);
        PaintedText paintedText = new PaintedText(Color.BLACK,"Lorum Ipsum test","Arial",paintedtextPoint,100,100);

        Point ovalPoint = new Point(20,20);
        Oval oval = new Oval(Color.BLACK,ovalPoint,50,50,40);

        Point imagePoint = new Point(15,100);
        File file = new File("C:\\Users\\Ken\\Google Drive\\Escuela\\S3\\SM-TE3\\Afbeeldingen\\beer.jpg");
        Image image = new Image(Color.BLACK, file, imagePoint,100,100);

        ArrayList<Point> polyPoints = new ArrayList<>();

        polyPoints.add(new Point(200,200));
        polyPoints.add(new Point(110,110));
        polyPoints.add(new Point(72,400));
        polyPoints.add(new Point(50,4));

        Polygon polygon = new Polygon(Color.BLACK,200,polyPoints);

        drawing.addDrawing(image);
        drawing.addDrawing(polygon);
        drawing.addDrawing(oval);
        drawing.addDrawing(paintedText);

        for(DrawingItem item : drawing.items){
            System.out.println(item);
           // Collections.sort(drawing.items, new DrawingItemComparator());
        }

        DrawingTool dt = new DrawingTool(drawing, new JavaFXPaintable(canvas.getGraphicsContext2D()));
        dt.draw();

        root.getChildren().add(canvas);
        primaryStage.setTitle("DrawApp");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


}
