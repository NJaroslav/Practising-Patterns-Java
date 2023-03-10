package view;

import model.BitSet;

import javax.swing.*;

public class ViewModel extends JTextArea {
    private final BitSet set;

    public ViewModel(BitSet set) {
        this.set = set;
        updateArea1();
        this.setVisible(true);
    }

    public void updateArea1() {
        StringBuilder sb = new StringBuilder();
        sb.append(set.toString()).append('\n');
        sb.append("Values: ");
        for (int i = 0; i < set.size(); ++i) {
            if (set.get(i) == 1) {
                sb.append(i).append(" ");
            }
        }
        this.setText(sb.toString());
    }
}
