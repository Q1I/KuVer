/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver.tweaks;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author q1
 */
public class TextLengthDocFilter extends DocumentFilter {

    private int maxTextLength;
    private int type;
    public static final int TYPE_NUMERIC = 0;
    public static final int TYPE_ALL = 1;

    /**
     * Document Filter for limiting input
     * @param maxTextLength max input size
     * @param type numeric or other
     */
    public TextLengthDocFilter(int maxTextLength, int type) {
        this.maxTextLength = maxTextLength;
        this.type = type;
    }

    private boolean verifyText(String text) {
        return text.length()-1 <= maxTextLength;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string,
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
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
//        System.out.println("replace:\n--->"+text);
//        System.out.println("length: "+length);
//        System.out.println("offSet: "+offset);
        if (!checkType(text)) {
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
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
        Document doc = fb.getDocument();
        String oldText = doc.getText(0, doc.getLength());
        StringBuilder sb = new StringBuilder(oldText);

        sb.replace(offset, offset + length, "");

        if (verifyText(sb.toString())) {
            super.remove(fb, offset, length);
        }
    }

    private boolean checkType(String text) {
        if (type == TYPE_NUMERIC) {
            if (!text.matches("[0-9]*")) {
                return false;
            }
        }
        return true;
    }
}
