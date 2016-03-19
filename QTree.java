package assignment7;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QTree {

    QTNode root;

    public QTree(Reader input) {
        try {
            root = readQTree(input);
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex); // Netbeans generated
        }
    }

    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(bitmap.getWidth(), bitmap);
    }

    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree(Writer sb) {
        root.writeNode(sb);
    }

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

    public static QTNode bitmap2QTree(int size, Bitmap bitmap) {
        if (bitmap.isPlain()) {
            return new Leaf(bitmap.getBit(0, 0));
        } else {
            return new GreyNode(
                    bitmap2QTree(size / 2, new Bitmap(bitmap, size / 2, 0, size / 2)),
                    bitmap2QTree(size / 2, new Bitmap(bitmap, size / 2, size / 2, size / 2)),
                    bitmap2QTree(size / 2, new Bitmap(bitmap, 0, size / 2, size / 2)),
                    bitmap2QTree(size / 2, new Bitmap(bitmap, 0, 0, size / 2))
            );
        }
    }

}
