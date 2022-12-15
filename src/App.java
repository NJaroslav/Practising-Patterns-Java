import controller.Controller;
import frame.Frame;
import model.MySet;
import view.ViewCardinality;
import view.ViewModel;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        MySet model = new MySet();
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