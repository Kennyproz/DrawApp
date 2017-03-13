package drawing.domain;

import drawing.domain.Drawingitems.Drawing;
import drawing.domain.Interfaces.PersistencyMediator;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Ken
 */
public class DatabaseMediator implements PersistencyMediator {

    Properties porps;
    Connection myConn;

    public DatabaseMediator() {

    }

    public DatabaseMediator(Properties porps, Connection myConn) {
        this.porps = porps;
        this.myConn = myConn;
    }

    public void closeConnection() throws SQLException {
        this.myConn.close();
    }

    public void initConnection() throws SQLException{
        String databaseUrl = "jdbc:mysql://studmysql01.fhict.local/dbi357714";
        String user = "dbi357714";
        String pass = "P@ssw0rd";
        myConn = DriverManager.getConnection(databaseUrl,user,pass );

    }

    @Override
    public Drawing load(String nameDrawing) throws SQLException, IOException, ClassNotFoundException {
        Statement myStmt;
        ResultSet myRs;
        initConnection();
        myConn = DriverManager.getConnection("jdbc:mysql://studmysql01.fhict.local/dbi357714", "dbi357714", "P@ssw0rd");
        System.out.println("Database connection succesful!1\n");
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("Select DrawingItem FROM Drawing WHERE DrawingName ='" + nameDrawing+ "';");

            byte[] drawingBytes;

            if (myRs.next()){
                drawingBytes = (byte[])myRs.getObject(1);
                ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(drawingBytes);
                ObjectInputStream objInputStream = new ObjectInputStream(arrayInputStream);
                Drawing drawing = (Drawing)objInputStream.readObject();
                return drawing;
            }
            myStmt.close();
        }
        catch (SQLException e
                ){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Drawing drawing) throws SQLException {
        PreparedStatement myStmt;
        try{
            initConnection();
            myConn = DriverManager.getConnection("jdbc:mysql://studmysql01.fhict.local/dbi357714", "dbi357714", "P@ssw0rd");
            System.out.println("Database connection succesful!");

            myStmt = myConn.prepareStatement("INSERT INTO Drawing (DrawingItem,DrawingName) VALUES (?,?)");

            ByteArrayOutputStream arrayOutStream = new ByteArrayOutputStream();
            ObjectOutputStream objOutStream = new ObjectOutputStream(arrayOutStream);
            objOutStream.writeObject(drawing);
            byte[] drawingBytes = arrayOutStream.toByteArray();

            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(drawingBytes);
            myStmt.setBinaryStream(1,arrayInputStream);
            myStmt.setString(2,drawing.getName());
            myStmt.executeUpdate();
            myStmt.close();

            System.out.println("Saved Succesfull");
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean init(Properties props) throws SQLException {
        return true;
    }
}
