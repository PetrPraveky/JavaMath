package lib.java.math.plotter;

import javax.swing.JFrame;
import lib.java.math.plotter.function_plotter.mobius_plotter;

public class plotter {
    public plotter(String function) {
        // Creating window
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (function == "mobius") {
            frame.add(new mobius_plotter());
        } else {}
        frame.setSize(400, 400);
        frame.setLocation(400, 200);
        frame.setVisible(true);
    }
}
