import javax.swing.plaf.PanelUI;

/**
 * to get a volume of both shelves and items for representing 3D dimension.
 */

public class Volume {
    private double height;
    private double width;
    private double depth;

    public Volume(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    /**
     * To get a height.
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * To set a height.
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * To get a width.
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * To set a width.
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * To get a depth.
     * @return
     */
    public double getDepth() {
        return depth;
    }

    /**
     * To set a depth.
     * @param depth
     */
    public void setDepth(double depth) {
        this.depth = depth;
    }

    /**
     * To get total volume.
     * @return volume (height * width * depth)
     */
    public double getVolume() {
        return height * width * depth;
    }

    /**
     * Calculate a bottom of Area: (width * depth).
     * Useful for placement logic.
     * @return bottom of Area: (width * depth).
     */
    public double getBottomArea(){
        return depth * width;
    }
}
