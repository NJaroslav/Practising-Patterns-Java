import controller.Controller;
import frame.Frame;
import model.BitSet;
import view.ViewCardinality;
import view.ViewModel;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        BitSet model = new BitSet();
        ViewModel viewModel = new ViewModel(model);
        ViewCardinality viewCardinality = new ViewCardinality(model);
        Controller controller = new Controller(model, viewModel, viewCardinality);
        controller.initializeController();
        Frame frame = new Frame(controller, viewModel, viewCardinality);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}