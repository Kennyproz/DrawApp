package drawing.domain;

import drawing.domain.Interfaces.IPaintable;

/**
 * Created by Ken
 */
public class PaintedText extends DrawingItem {

    private String content;
    private String fontName;
    private Point anchor;
    private double width;
    private double height;

    /**
     * Constructor for paintedtext
     * @param color
     */
    public PaintedText(Color color) {
        super(color);
    }

    /**
     * Constructor for paintedtext
     * @param color
     * @param content
     * @param fontName
     * @param anchor
     * @param width
     * @param height
     */
    public PaintedText(Color color, String content, String fontName, Point anchor, double width, double height) {
        super(color);
        this.content = content;
        this.fontName = fontName;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintUsing(IPaintable paintable) {
        paintable.paint(this);
    }

    /**
     * Get content for paintedtext
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content for paintedtext
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get fontname for paintedtext
     * @return
     */
    public String getFontName() {
        return fontName;
    }

    /**
     * Set fontname for paintedtext
     * @param fontName
     */
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    /**
     * Set height for paintedtext
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Set anchor for paintedtext
     * @param anchor
     */
    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    /**
     * Set width for paintedtext
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get anchor for paintedtext
     * @return
     */
    @Override
    public Point getAnchor() {
        return anchor;
    }

    /**
     * Get width for paintedtext
     * @return
     */
    @Override
    public double getWidth() {
        return width;
    }

    /**
     * Get height for paintedtext
     * @return
     */
    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "PaintedText{" +
                "content='" + content + '\'' +
                ", fontName='" + fontName + '\'' +
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
        }}
}
