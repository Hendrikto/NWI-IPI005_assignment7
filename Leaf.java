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

    public Leaf(boolean type) {
        this.type = type ? LeafType.black : LeafType.white;
    }

    @Override
    public void fillBitmap(int x, int y, int size, Bitmap b) {
        b.fillArea(x, y, size, this.type == LeafType.black);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.append(this.type == LeafType.black ? "00" : "01");
        } catch (IOException ex) {
            Logger.getLogger(Leaf.class.getName()).log(Level.SEVERE, null, ex); // NetBeans generated
        }
    }

}
