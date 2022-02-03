import lib.java.math.functions.mobius_function;
import lib.java.math.plotter.plotter;
import lib.java.math.functions.riemann_zeta_function;
import lib.java.math.functions.gamma_function;
import lib.java.math.complex.ComplexNumbers;

public class App {
    public static void main(String[] args) throws Exception {
        // // Mobius function
        // mobius_function mobius = new mobius_function();
        // for (int i = 1; i <= 50; i++) {
        //     System.out.println(String.valueOf(i)+"\t"+String.valueOf(mobius._mobius_function(i)));
        // }
        // // Mobius function plotter
        // new plotter("mobius");

        // // Riemann zeta function
        // riemann_zeta_function zeta = new riemann_zeta_function();
        // System.out.println(zeta._riemann_zeta_function(1.1));
        // // Riemann zeta function plotter
        // new plotter("zeta");

        // // Gamma function
        // gamma_function gamma = new gamma_function();
        // System.out.println(gamma._gamma_function(0));
        // // Gamma function plotter
        // new plotter("gamma");

        // Complex numbers
        ComplexNumbers c1 = new ComplexNumbers(12.5, 2.5);
        ComplexNumbers c2 = new ComplexNumbers(0.95, 0.5);
        c1.display(); c2.display();
    }
}
