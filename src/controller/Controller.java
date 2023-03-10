package controller;

import model.BitSet;
import strategy.CardinalityStrategyIterator;
import strategy.CardinalityStrategyBase;
import view.ViewCardinality;
import view.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Controller extends JPanel {
    private final JButton addButton;
    private final JButton cardinalityButton;
    private final BitSet model;
    private final ViewModel viewModel;
    private final ViewCardinality viewCardinality;

    public Controller(BitSet m, ViewModel vm, ViewCardinality vc) {
        model = m;
        viewModel = vm;
        viewCardinality = vc;

        addButton = new JButton("add");
        cardinalityButton = new JButton("Cardinality");

        this.add(addButton);
        this.add(cardinalityButton);
    }

    public void initializeController() {
        addButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String el = JOptionPane.showInputDialog("Input integer value");
                if (el == null) {
                    viewModel.append("Input correct element");
                } else {
                    try {
                        Integer element = Integer.valueOf(el);
                        model.add(element);
                        viewModel.updateArea1();
                    } catch (NumberFormatException exception) {
                        viewModel.append("The Input is not an Integer type");
                    }
                }
            }
        });

        cardinalityButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setCardinalityStrategy(new CardinalityStrategyIterator());
                int size1 = model.getCardinalityByStrategy();

                model.setCardinalityStrategy(new CardinalityStrategyBase());
                int size2 = model.getCardinalityByStrategy();

                viewCardinality.updateArea2(size1, size2);
            }
        });
    }

}
