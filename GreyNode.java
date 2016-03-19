package assignment7;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class GreyNode implements QTNode {

    private final QTNode[] children = new QTNode[4];

    public GreyNode(QTNode... children) {
        if (children.length != 4) {
            throw new Error("Invalid number of children.");
        }
        System.arraycopy(children, 0, this.children, 0, 4);
    }

    @Override
    public void fillBitmap(int x, int y, int size, Bitmap b) {
        children[0].fillBitmap(x + size / 2, y, size / 2, b);
        children[1].fillBitmap(x + size / 2, y + size / 2, size / 2, b);
        children[2].fillBitmap(x, y + size / 2, size / 2, b);
        children[3].fillBitmap(x, y, size / 2, b);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.append('1');
            for (QTNode n : children) {
                n.writeNode(out);
            }
        } catch (IOException ex) {
            Logger.getLogger(GreyNode.class.getName()).log(Level.SEVERE, null, ex); // NetBeans generated
        }
    }
}
