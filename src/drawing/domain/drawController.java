package drawing.domain;

import com.sun.javafx.scene.layout.region.Margins;
import drawing.domain.Drawingitems.*;
import drawing.domain.Enums.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.DoubleSummaryStatistics;
import java.util.ResourceBundle;

/**
 * Created by Ken on 19-3-2017.
 */
public class drawController implements Initializable {

    @FXML private Canvas canvas;
    @FXML private ComboBox cbDrawingitems;
    @FXML private ComboBox cbPaintedItems;
    @FXML private TextField tbWidth;
    @FXML private TextField tbHeight;
    @FXML private TextField tbText;
    @FXML private Button btnAdd;
    @FXML private Button btnClear;
    @FXML private Button btnRemove;

    Point point;

    private GraphicsContext graphicsContext;
    private Drawing drawing;

    public void clear(){
        graphicsContext.clearRect(0,0, canvas.getWidth(),canvas.getHeight());
        drawing.getItems().removeAll(drawing.getItems());
    }
    public void draw (){
        graphicsContext.clearRect(0,0, canvas.getWidth(),canvas.getHeight());
        drawing.paintUsing(new JavaFXPaintable(graphicsContext));
        fillItemList();
    }
    public void removeItem(){
        drawing.getItems().remove((DrawingItem)(cbPaintedItems.getSelectionModel().getSelectedItem()));
        graphicsContext.clearRect(0,0, canvas.getWidth(),canvas.getHeight());
        drawing.paintUsing(new JavaFXPaintable(graphicsContext));
        fillItemList();
    }

    public void drawItem(MouseEvent me){
        point = new Point(me.getX(),me.getY());
        double width;
        double height;
        if (tbWidth.getText() != "")
        {
            width = Double.parseDouble(tbWidth.getText().toString());
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error");
            return;
        }
        if (tbHeight.getText() != "")
        {
            height = Double.parseDouble(tbHeight.getText().toString());
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error");
            return;
        }
        try{
            switch (cbDrawingitems.getSelectionModel().getSelectedItem().toString()){
                case "Oval":
                    Oval oval = new Oval(Color.BLACK,point,10,height,width);
                    drawing.addDrawing(oval);
                    break;
                case "PaintedText":
                    PaintedText paintedText = new PaintedText(Color.BLACK,tbText.getText(),"Arial",point,width,height);
                    drawing.addDrawing(paintedText);
                    break;
                case "Image":
                    File file = new File("C:\\Users\\Ken\\Google Drive\\Escuela\\S3\\SM-TE3\\Afbeeldingen\\aahappy.png");
                    Image image = new Image(Color.BLACK, file, point,width,height);
                    drawing.addDrawing(image);
                    break;
                case "Polygon":
                    return;
                default: return;

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        draw();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        graphicsContext = canvas.getGraphicsContext2D();
        drawing = new Drawing();
        fillTypeList();


       canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX());
                System.out.println(event.getY());
                drawItem(event);
            }
        });
    }

    private void fillTypeList(){
        cbDrawingitems.getItems().removeAll(cbDrawingitems.getItems());
        cbDrawingitems.getItems().add("Oval");
        cbDrawingitems.getItems().add("PaintedText");
        cbDrawingitems.getItems().add("Image");
        cbDrawingitems.getItems().add("Polygon");
        cbDrawingitems.getItems().add("Drawing");

    }
    private void fillItemList(){
        cbPaintedItems.getItems().removeAll(cbPaintedItems.getItems());
        if (drawing.getItems().size() > 0 ){
            for (DrawingItem item : drawing.getItems()){
                cbPaintedItems.getItems().add(item);
            }
        }
        else
        {
            return;
        }
    }


}
