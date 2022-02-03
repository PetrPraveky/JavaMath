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
        ComplexNumbers c1 = new ComplexNumbers(12.5, -2.5);
        ComplexNumbers c2 = new ComplexNumbers(09.5, 0.5);
        ComplexNumbers c3 = new ComplexNumbers(); // Addition
        c3 = c1.add(c2); c3.display();
        ComplexNumbers c4 = new ComplexNumbers(); // Substraction
        c4 = c1.sub(c2); c4.display();
        ComplexNumbers c5 = new ComplexNumbers(); // Multiplication
        c5 = c1.mul(c2); c5.display();
        ComplexNumbers c6 = new ComplexNumbers(); // Square
        c6 = c1.square(); c6.display();
        ComplexNumbers c7 = new ComplexNumbers(); // Square root
        c7 = c1.root(); c7.display();
        ComplexNumbers c8 = new ComplexNumbers(); // Division
        c8 = c1.div(c2); c8.display();
        ComplexNumbers c9 = new ComplexNumbers(); // Exponential
        c9 = c1.exp(); c9.display();
        ComplexNumbers c10 = new ComplexNumbers(); // Natural logarithm
        c10 = c1.ln(); c10.display();
        ComplexNumbers c11 = new ComplexNumbers(); // Sin
        c11 = c1.sin(); c11.display();
        ComplexNumbers c12 = new ComplexNumbers(); // Cos
        c12 = c1.cos(); c12.display();
        ComplexNumbers c13 = new ComplexNumbers(); // Exponentiation
        c13 = c1.pow(c2); c13.display();
    }
}
