package lib.java.math.plotter;

import javax.swing.JFrame;

import lib.java.math.plotter.complex_function_plotter.complex_beta_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_gamma_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_zeta_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_hyperbolic.complex_cosh_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_hyperbolic.complex_coth_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_hyperbolic.complex_csch_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_hyperbolic.complex_sech_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_hyperbolic.complex_sinh_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_hyperbolic.complex_tanh_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_trigonometry.complex_cos_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_trigonometry.complex_cot_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_trigonometry.complex_csc_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_trigonometry.complex_sec_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_trigonometry.complex_sin_plotter;
import lib.java.math.plotter.complex_function_plotter.complex_trigonometry.complex_tan_plotter;
import lib.java.math.plotter.complex_function_plotter.fourier_series.eisenstein_plotter;
import lib.java.math.plotter.function_plotter.gamma_plotter;
import lib.java.math.plotter.function_plotter.mobius_plotter;
import lib.java.math.plotter.function_plotter.zeta_plotter;
import lib.java.math.plotter.function_plotter.fourier_series.sawtooth_wave_plotter;

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
        } else if (function == "complex_gamma") {
            frame.add(new complex_gamma_plotter());
        } else if (function == "complex_zeta") {
            frame.add(new complex_zeta_plotter());
        } else if (function == "sawtooth_wave") {
            frame.add(new sawtooth_wave_plotter());
        } else if (function == "complex_sin") {
            frame.add(new complex_sin_plotter());
        } else if (function == "complex_cos") {
            frame.add(new complex_cos_plotter());
        } else if (function == "complex_tan") {
            frame.add(new complex_tan_plotter());
        } else if (function == "complex_cot") {
            frame.add(new complex_cot_plotter());
        } else if (function == "complex_sec") {
            frame.add(new complex_sec_plotter());
        } else if (function == "complex_csc") {
            frame.add(new complex_csc_plotter());
        } else if (function == "complex_sinh") {
            frame.add(new complex_sinh_plotter());
        } else if (function == "complex_cosh") {
            frame.add(new complex_cosh_plotter());
        } else if (function == "complex_tanh") {
            frame.add(new complex_tanh_plotter());
        } else if (function == "complex_coth") {
            frame.add(new complex_coth_plotter());
        } else if (function == "complex_sech") {
            frame.add(new complex_sech_plotter());
        } else if (function == "complex_csch") {
            frame.add(new complex_csch_plotter());
        } else if (function == "complex_beta") {
            frame.add(new complex_beta_plotter());
        }
        frame.setSize(400, 400);
        frame.setLocation(400, 200);
        frame.setVisible(true);
    }
    public plotter(String function, int k) {
        // Creating window
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (function == "eisenstein_s") {
            frame.add(new eisenstein_plotter(k));
        }
        frame.setSize(400, 400);
        frame.setLocation(400, 200);
        frame.setVisible(true);
    }

}
