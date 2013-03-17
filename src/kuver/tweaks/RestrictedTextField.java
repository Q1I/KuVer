/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver.tweaks;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author q1
 */
public class RestrictedTextField extends JTextField {

    public RestrictedTextField(int maxTextLength) {
        PlainDocument doc = (PlainDocument) this.getDocument();
        doc.setDocumentFilter(new kuver.tweaks.TextLengthDocFilter(maxTextLength, 1));
    }

    private class TextLengthDocFilter extends DocumentFilter {

        private int maxTextLength;
        public static final int TYPE_NUMERIC = 0;
        public static final int TYPE_ALL = 1;
        
        
        public TextLengthDocFilter(int maxTextLength) {
            this.maxTextLength = maxTextLength;
        }

        private boolean verifyText(String text) {
            return text.length() <= maxTextLength;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string,
                AttributeSet attr) throws BadLocationException {

            Document doc = fb.getDocument();
            String oldText = doc.getText(0, doc.getLength());
            StringBuilder sb = new StringBuilder(oldText);
            sb.insert(offset, string);

            if (verifyText(sb.toString())) {
                super.insertString(fb, offset, string, attr);
            }

        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (!text.matches("[0-9]")) {
                return;
            }
            Document doc = fb.getDocument();
            String oldText = doc.getText(0, doc.getLength());
            StringBuilder sb = new StringBuilder(oldText);

            sb.replace(offset, offset + length, text);
            if (verifyText(sb.toString())) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            Document doc = fb.getDocument();
            String oldText = doc.getText(0, doc.getLength());
            StringBuilder sb = new StringBuilder(oldText);

            sb.replace(offset, offset + length, "");

            if (verifyText(sb.toString())) {
                super.remove(fb, offset, length);
            }
        }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(new RestrictedTextField(2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(100, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}
