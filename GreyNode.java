package assignment7;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A QTNode that has 4 children.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class GreyNode implements QTNode {

    private final QTNode[] children = new QTNode[4];

    /**
     * Constructor method.
     *
     * @param children the four children of this node
     */
    public GreyNode(QTNode... children) {
        if (children.length != 4) {
            throw new Error("Invalid number of children.");
        }
        this.children[0] = children[1];
        this.children[1] = children[2];
        this.children[2] = children[3];
        this.children[3] = children[0];
    }

    /**
     * Fill a Bitmap recursively.
     *
     * @param x the x-offset
     * @param y the y-offset
     * @param size the size of the area this node represents
     * @param b the Bitmap to fill
     */
    @Override
    public void fillBitmap(int x, int y, int size, Bitmap b) {
        children[0].fillBitmap(x + size / 2, y, size / 2, b);
        children[1].fillBitmap(x + size / 2, y + size / 2, size / 2, b);
        children[2].fillBitmap(x, y + size / 2, size / 2, b);
        children[3].fillBitmap(x, y, size / 2, b);
    }

    /**
     * Write the QTree recursively to a Writer beginning from this node.
     *
     * @param out the Writer to use
     */
    @Override
    public void writeNode(Writer out) {
        try {
            out.append('1');
            children[3].writeNode(out);
            children[0].writeNode(out);
            children[1].writeNode(out);
            children[2].writeNode(out);
        } catch (IOException ex) {
            Logger.getLogger(GreyNode.class.getName()).log(Level.SEVERE, null, ex); // NetBeans generated
        }
    }
}
