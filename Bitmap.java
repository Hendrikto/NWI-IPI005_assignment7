package assignment7;

/**
 * Bitmap: A class for representing bitmap.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 * @author Sjaak Smetsers
 * @version 15-03-2016
 */
public class Bitmap {

    // each bit is stored into an two dimensional array
    private final boolean[][] raster;
    private final int bmWidth, bmHeight;

    /**
     * Create an empty bitmap of size width * height.
     *
     * @param width
     * @param height
     */
    public Bitmap(int width, int height) {
        this.raster = new boolean[width][height];
        this.bmWidth = width;
        this.bmHeight = height;
    }

    /**
     * Generate a Bitmap from another one.
     *
     * @param template the template Bitmap
     * @param offsetX the x-offset
     * @param offsetY the y-offset
     * @param size the size of the generated Bitmap
     */
    public Bitmap(Bitmap template, int offsetX, int offsetY, int size) {
        this.raster = new boolean[size][size];
        this.bmWidth = this.bmHeight = size;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.setBit(x, y, template.getBit(x + offsetX, y + offsetY));
            }
        }
    }

    /**
     * Get a bit at the specified position.
     *
     * @param x: x coordinate
     * @param y: y coordinate
     * @return the bit at the specified position
     */
    public final boolean getBit(int x, int y) {
        return this.raster[x][y];
    }

    /**
     * Set a bit at the specified position.
     *
     * @param x: x coordinate
     * @param y: y coordinate
     * @param val: the bit value
     */
    public final void setBit(int x, int y, boolean val) {
        this.raster[x][y] = val;
    }

    /**
     * Check whether this Bitmap is plain (= one-colored).
     *
     * @return whether this Bitmap is plain
     */
    public final boolean isPlain() {
        boolean first = this.raster[0][0];
        for (int x = 0; x < this.bmWidth; x++) {
            for (int y = 0; y < this.bmHeight; y++) {
                if (this.raster[x][y] != first) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Convert a Bitmap into a string.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.bmHeight; y++) {
            for (int x = 0; x < this.bmWidth; x++) {
                sb.append(this.raster[x][y] ? "* " : "O ");
            }
            sb.append('\n');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * Get the width of this Bitmap.
     *
     * @return the width of the Bitmap
     */
    public int getWidth() {
        return this.bmWidth;
    }

    /**
     * Get the height of this Bitmap.
     *
     * @return the height of the Bitmap
     */
    public int getHeight() {
        return this.bmHeight;
    }

    /**
     * Fills a square area of a bitmap with value val.
     *
     * @param x: x coordinate of upper-left corner
     * @param y: y coordinate of upper-left corner
     * @param size: size of the square
     * @param val: the bit value
     */
    public void fillArea(int x, int y, int size, boolean val) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.setBit(x + i, y + j, val);
            }
        }
    }

}
