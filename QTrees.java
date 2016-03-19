package assignment7;

import java.io.StringReader;
import java.io.StringWriter;

public class QTrees {

    public static void main(String[] args) {
        String test_text = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_text);
        StringWriter output1 = new StringWriter();
        StringWriter output2 = new StringWriter();
        Bitmap bitmap = new Bitmap(8, 8);

        QTree qt = new QTree(input);
        System.out.printf("Convert String to QTree:\n%s\n\n", qt);

        qt.writeQTree(output1);
        System.out.printf("Convert QTree to String:\n%s\n\n", output1);

        qt.fillBitmap(bitmap);
        System.out.printf("Convert QTree to Bitmap:\n%s\n\n", bitmap);

        QTree qt2 = new QTree(bitmap);
        System.out.printf("Convert Bitmap to QTree:\n%s\n\n", qt2);

        qt2.writeQTree(output2);
        System.out.printf("Is that the same as the original input? %b\n", output2.toString().equals(test_text));
    }

}
