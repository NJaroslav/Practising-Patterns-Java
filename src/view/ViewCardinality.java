package view;

import model.BitSet;

import javax.swing.*;

public class ViewCardinality extends JTextArea {
    private final BitSet set;

    public ViewCardinality(BitSet set) {
        this.set = set;
        updateArea2(0, 0);
        this.setVisible(true);
    }

    public void updateArea2(int size1, int size2) {
        this.setText("Strategy #1: " + size1 + '\n' + "Strategy #2: " + size2);
    }
}
