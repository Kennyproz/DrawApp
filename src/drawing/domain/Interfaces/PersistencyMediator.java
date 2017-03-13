package drawing.domain.Interfaces;


import drawing.domain.Drawingitems.Drawing;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Ken on 7-3-2017.
 */
public interface PersistencyMediator {
    Drawing load(String nameDrawing) throws SQLException, IOException, ClassNotFoundException;
    boolean save(Drawing drawing) throws SQLException;
    boolean init(Properties props) throws SQLException;
}
