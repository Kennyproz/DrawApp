package drawing.domain;

import drawing.domain.Drawingitems.Drawing;
import drawing.domain.Interfaces.PersistencyMediator;

import java.io.*;
import java.util.Properties;

/**
 * Created by Ken on 8-3-2017.
 */
public class SerializationMediator implements PersistencyMediator {
    //Locating the file in given location, and creating a Drawing item of it. (Load drawing)
    @Override
    public Drawing load(String nameDrawing) throws ClassNotFoundException, IOException {

        try {

            FileInputStream streamInFile = new FileInputStream("C:\\Users\\Ken\\Desktop\\" + nameDrawing + ".ser");
            ObjectInputStream objectInStream = new ObjectInputStream(streamInFile);
            return (Drawing)objectInStream.readObject();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
    //Saving the Drawing as .ser file on desktop. (Save drawing)
    @Override
    public boolean save(Drawing drawing) {

        try {

            File outputFile = new File("C:\\Users\\Ken\\Desktop\\" + drawing.getName() + ".ser");
            System.out.println("Drawing at:" + outputFile.getAbsolutePath());

            FileOutputStream streamOutFile = new FileOutputStream(outputFile);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(streamOutFile);
            objectOutStream.writeObject(drawing);
            System.out.println("Saved Succesfull");

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }
}
