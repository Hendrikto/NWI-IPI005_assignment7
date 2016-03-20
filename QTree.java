package assignment7;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generate and output QTrees.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class QTree {

    QTNode root;

    /**
     * Constructor method.
     *
     * @param input a Reader to generate the QTree from
     */
    public QTree(Reader input) {
        try {
            root = readQTree(input);
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex); // Netbeans generated
        }
    }

    /**
     * Constructor method.
     *
     * @param bitmap a Bitmap to generate the QTree from
     */
    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(bitmap.getWidth(), bitmap);
    }

    /**
     * Fill a Bitmap with the QTree.
     *
     * @param bitmap the Bitmap to fill
     */
    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    /**
     * Write the QTree to a Writer.
     *
     * @param sb the Writer to write to
     */
    public void writeQTree(Writer sb) {
        root.writeNode(sb);
    }

    /**
     * Generate a QTree from a Reader. Assumes pre-order traversal.
     *
     * @param input the Reader to read from
     * @return the QTNode generated
     * @throws IOException
     */
    private static QTNode readQTree(Reader input) throws IOException {
        int character = input.read();
        switch (character) {
            case '0':
                return new Leaf((char) input.read());
            case '1':
                return new GreyNode(readQTree(input), readQTree(input), readQTree(input), readQTree(input));
            default:
                throw new Error(String.format("Invalid character: %c", (char) character));
        }
    }

    /**
     * Recursively generate a QTree from a Bitmap.
     *
     * @param size the size of the Bitmap
     * @param bitmap the Bitmap
     * @return the node generated
     */
    public static QTNode bitmap2QTree(int size, Bitmap bitmap) {
        if (bitmap.isPlain()) {
            return new Leaf(bitmap.getBit(0, 0));
        } else {
            return new GreyNode(
                    bitmap2QTree(size / 2, new Bitmap(bitmap, 0, 0, size / 2)),
                    bitmap2QTree(size / 2, new Bitmap(bitmap, size / 2, 0, size / 2)),
                    bitmap2QTree(size / 2, new Bitmap(bitmap, size / 2, size / 2, size / 2)),
                    bitmap2QTree(size / 2, new Bitmap(bitmap, 0, size / 2, size / 2))
            );
        }
    }

}
