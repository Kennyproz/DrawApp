package drawing.domain;

import drawing.domain.Interfaces.IPaintable;

import java.io.File;


/**
 * Created by Ken
 */
public class Image extends DrawingItem  {
    private File file;
    private Point anchor;
    private double width;
    private double height;

    public Image(Color color) {
        super(color);
    }


    public Image(Color color, File file, Point anchor, double width, double height) {
        super(color);
        this.file = file;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintUsing(IPaintable paintable) {
        paintable.paint(this);
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public Point getAnchor() {
        return anchor;
    }

    @Override
    public double getWidth() {
        return width;
    }

    /**
     * Get height for image
     * @return
     */
    @Override
    public double getHeight() {
        return height;
    }

    /**
     * Get file for image
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     * Set file for image
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Image{" +
                "file=" + file +
                ", anchor=" + anchor +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
    @Override
    public int compare(DrawingItem itemOne, DrawingItem itemTwo) {
        boolean points = itemOne.getAnchor().equals(itemTwo.getAnchor());
        if (points)
        {
            return 1;
        }
        else {
            return 0;
        }
}}
