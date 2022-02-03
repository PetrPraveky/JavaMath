package lib.java.math.plotter;

import javax.swing.JFrame;

import lib.java.math.plotter.function_plotter.gamma_plotter;
import lib.java.math.plotter.function_plotter.mobius_plotter;
import lib.java.math.plotter.function_plotter.zeta_plotter;

public class plotter {
    public plotter(String function) {
        // Creating window
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (function == "mobius") {
            frame.add(new mobius_plotter());
        } else if (function == "gamma") {
            frame.add(new gamma_plotter());
        } else if (function == "zeta") {
            frame.add(new zeta_plotter());
        }
        frame.setSize(400, 400);
        frame.setLocation(400, 200);
        frame.setVisible(true);
    }
}
