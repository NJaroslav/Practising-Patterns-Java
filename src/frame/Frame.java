package frame;

import controller.Controller;
import view.ViewCardinality;
import view.ViewModel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final Controller controllerPanel;
    private final ViewModel viewModel;
    private final ViewCardinality viewCardinality;
    private final JScrollPane scrollModel;
    private final JScrollPane scrollAlgo;

    public Frame(Controller c, ViewModel vm, ViewCardinality vc) {
        this.controllerPanel = c;
        this.viewModel = vm;
        this.viewCardinality = vc;

        viewCardinality.setEditable(false);
        viewModel.setEditable(false);
        scrollModel = new JScrollPane(viewModel);
        scrollModel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollAlgo = new JScrollPane(viewCardinality);
        scrollAlgo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        this.setLayout(new GridLayout(3, 1));
        this.add(scrollModel, BorderLayout.WEST);
        this.add(scrollAlgo, BorderLayout.EAST);
        this.add(controllerPanel, BorderLayout.SOUTH);
    }
}
