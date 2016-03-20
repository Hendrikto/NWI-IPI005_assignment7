package assignment7;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This represents a Leaf Node. We chose to use only one class for this contrary
 * to what was suggested on the exercise sheet as the only difference between
 * WhiteLeaf and BlackLeaf is the color.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Leaf implements QTNode {

    /**
     * An enumeration of possible types of Leaf nodes.
     */
    private enum LeafType {
        black, white;

        /**
         * Get the LeapType from a char. '0' is interpreted as black, anything
         * else as white.
         *
         * @param type a char
         * @return the LeafType
         */
        public static LeafType getType(int type) {
            return type == '0' ? LeafType.black : LeafType.white;
        }
    }

    private final LeafType type;

    /**
     * Constructor method.
     *
     * @param type '0' for black Leaf, anything else for white Leaf
     */
    public Leaf(int type) {
        this.type = LeafType.getType(type);
    }

    /**
     * Constructor method.
     *
     * @param type the type of the Leaf (true = black; false = white)
     */
    public Leaf(boolean type) {
        this.type = type ? LeafType.black : LeafType.white;
    }

    /**
     * Fill an area of a Bitmap with the color of this Leaf.
     *
     * @param x the x-offset
     * @param y the y-offset
     * @param size the size of the area
     * @param b the Bitmap
     */
    @Override
    public void fillBitmap(int x, int y, int size, Bitmap b) {
        b.fillArea(x, y, size, this.type == LeafType.black);
    }

    /**
     * Write this Leaf to a Writer.
     *
     * @param out the Writer to write to
     */
    @Override
    public void writeNode(Writer out) {
        try {
            out.append(this.type == LeafType.black ? "00" : "01");
        } catch (IOException ex) {
            Logger.getLogger(Leaf.class.getName()).log(Level.SEVERE, null, ex); // NetBeans generated
        }
    }

}
