package assignment7;

import java.io.Writer;

/**
 * A Node of a QTree.
 *
 * @author Sjaak Smetsers
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 * @version 11-03-2016
 */
public interface QTNode {

    public void fillBitmap(int x, int y, int width, Bitmap bitmap);

    public void writeNode(Writer out);
}
