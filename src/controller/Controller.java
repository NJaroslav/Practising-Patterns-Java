package controller;

import model.MySet;
import strategy.CardinalityStrategy1;
import strategy.CardinalityStrategy2;
import view.ViewCardinality;
import view.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller extends JPanel {
    private final JButton addButton;
    private final JButton cardinalityButton;
    private final MySet model;
    private final ViewModel viewModel;
    private final ViewCardinality viewCardinality;

    public Controller(MySet m, ViewModel vm, ViewCardinality vc) {
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
                model.setCardinalityStrategy(new CardinalityStrategy1());
                int size1 = model.getCardinalityByStrategy();

                model.setCardinalityStrategy(new CardinalityStrategy2());
                int size2 = model.getCardinalityByStrategy();

                viewCardinality.updateArea2(size1, size2);
            }
        });
    }

}
