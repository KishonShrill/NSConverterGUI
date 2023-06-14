import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NoSpaceTextArea extends JTextArea {

    public NoSpaceTextArea() {
        setDocument(new NoSpaceDocument());
    }

    private class NoSpaceDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            // Remove any spaces from the inserted text
            str = str.replaceAll("\\s", "");

            // Call the super method to insert the modified text
            super.insertString(offs, str, a);
        }
    }
}
