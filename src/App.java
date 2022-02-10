import lib.java.math.functions.mobius_function;
import lib.java.math.plotter.plotter;
import lib.java.math.functions.riemann_zeta_function;
import lib.java.math.functions.bernoulli_number;
import lib.java.math.functions.binomial_coefficient;
import lib.java.math.functions.divisor_function;
import lib.java.math.functions.gamma_function;

import java.math.BigDecimal;

import lib.java.constants.constants;
import lib.java.math.complex.BigComplexNumbers;
import lib.java.math.complex.ComplexNumbers;
import lib.java.math.complex.functions.complex_beta_function;
import lib.java.math.complex.functions.complex_gamma_function;
import lib.java.math.complex.functions.complex_hurwitz_zeta_function;
import lib.java.math.complex.functions.complex_stieltjes_constant;
import lib.java.math.complex.functions.complex_zeta_function;
import lib.java.math.complex.functions.hurwitz_zeta_function;
import lib.java.math.complex.functions.fourier_series.eisenstein_series;

public class App {
    public static void main(String[] args) throws Exception {
        /*
        // new IntegrationTest();
        // // Mobius function
        // mobius_function mobius = new mobius_function();
        // for (int i = 1; i <= 50; i++) {
        //     System.out.println(String.valueOf(i)+"\t"+String.valueOf(mobius._mobius_function(i)));
        // }
        // // Mobius function plotter
        // new plotter("mobius");

        // // Riemann zeta function
        // riemann_zeta_function zeta = new riemann_zeta_function();
        // System.out.println(zeta._riemann_zeta_function(4));
        // // Riemann zeta function plotter
        // new plotter("zeta");

        // // Gamma function
        // gamma_function gamma = new gamma_function();
        // System.out.println(gamma._gamma_function(-2));
        // // Gamma function plotter
        // new plotter("gamma");

        // // Bernoulli number
        // bernoulli_number number = new bernoulli_number();
        // System.out.println(number._bernoulli_number(4));

        // // Binominal coefficient
        // binomial_coefficient binominal = new binomial_coefficient();
        // System.out.println(binominal._binomial_coefficient(4, 2));

        
        // // Divisor function
        // divisor_function divisor = new divisor_function();
        // System.out.println(divisor._divisor_function(0, 12));
        */
        // Complex numbers
        /*
        ComplexNumbers c1 = new ComplexNumbers(12.5, -2.5);
        ComplexNumbers c2 = new ComplexNumbers(09.5, 0.5);
        // ComplexNumbers c3 = new ComplexNumbers(); // Addition
        // c3 = c1.add(c2); c3.display();
        // ComplexNumbers c4 = new ComplexNumbers(); // Substraction
        // c4 = c1.sub(c2); c4.display();
        // ComplexNumbers c5 = new ComplexNumbers(); // Multiplication
        // c5 = c1.mul(c2); c5.display();
        // ComplexNumbers c6 = new ComplexNumbers(); // Square
        // c6 = c1.square(); c6.display();
        // ComplexNumbers c7 = new ComplexNumbers(); // Square root
        // c7 = c1.root(); c7.display();
        // ComplexNumbers c8 = new ComplexNumbers(); // Division
        // c8 = c1.div(c2); c8.display();
        // ComplexNumbers c9 = new ComplexNumbers(); // Exponential
        // c9 = c1.exp(); c9.display();
        // ComplexNumbers c10 = new ComplexNumbers(); // Natural logarithm
        // c10 = c1.ln(); c10.display();
        // ComplexNumbers c11 = new ComplexNumbers(); // Sin
        // c11 = c1.sin(); c11.display();
        // ComplexNumbers c12 = new ComplexNumbers(); // Cos
        // c12 = c1.cos(); c12.display();
        // ComplexNumbers c13 = new ComplexNumbers(); // Exponentiation
        // c13 = c1.pow(c2); c13.display();
        // ComplexNumbers c14 = new ComplexNumbers(); // Arctan
        // c14 = c1.atan(); c14.display();
        // System.out.println(c1.mod()); // Mod
        // ComplexNumbers c15 = new ComplexNumbers(); // Tan
        // c15 = c1.tan(); c15.display();
        // ComplexNumbers c16 = new ComplexNumbers(); // Cot
        // c16 = c1.cot(); c16.display();
        // ComplexNumbers c17 = new ComplexNumbers(); // Sec
        // c17 = c1.sec(); c17.display();
        // ComplexNumbers c18 = new ComplexNumbers(); // Csc
        // c18 = c1.csc(); c18.display();
        // ComplexNumbers c19 = new ComplexNumbers(); // Sinh
        // c19 = c1.sinh(); c19.display();
        // ComplexNumbers c20 = new ComplexNumbers(); // Cosh
        // c20 = c1.cosh(); c20.display();
        // ComplexNumbers c21 = new ComplexNumbers(); // Tanh
        // c21 = c1.tanh(); c21.display();
        // ComplexNumbers c22 = new ComplexNumbers(); // Coth
        // c22 = c1.coth(); c22.display();
        // ComplexNumbers c23 = new ComplexNumbers(); // Sech
        // c23 = c1.sech(); c23.display();
        // ComplexNumbers c24 = new ComplexNumbers(); // Csch
        // c24 = c1.csch(); c24.display();
        */
        // Complex functions
        /*
        // System.out.println("");
        ComplexNumbers i1 = new ComplexNumbers(-2.5, 0.5);
        // complex_gamma_function gamma = new complex_gamma_function();
        // ComplexNumbers o1 = new ComplexNumbers();
        // o1 = gamma._gamma_function(i1); o1.display();
        // complex_zeta_function zeta = new complex_zeta_function();
        // ComplexNumbers o2 = new ComplexNumbers();
        // o2 = zeta._riemann_zeta_function(i1); o2.display();
        // ComplexNumbers i2 = new ComplexNumbers(-2, 4);
        // complex_beta_function beta = new complex_beta_function();
        // ComplexNumbers o3 = new ComplexNumbers();
        // o3 = beta._complex_beta_function(i1, i2); o3.display();
        // ComplexNumbers o4 = new ComplexNumbers();
        // eisenstein_series e = new eisenstein_series();
        // o4 = e.G(2, i1); o4.display();
        // ComplexNumbers i3 = new ComplexNumbers(1.5, 0.5);
        // ComplexNumbers o5 = new ComplexNumbers();
        // hurwitz_zeta_function zeta = new hurwitz_zeta_function();
        // o5 = zeta._hurwitz_zeta_function(i1, i3); o5.display();
        // ComplexNumbers o6 = new ComplexNumbers();
        // generalized_stieljes_constant stieljes = new generalized_stieljes_constant();
        // o6 = stieljes._stieljes_constant(2, i1); o6.display();
        */
        // Complex plotter
        /*
        // new plotter("complex_gamma");
        // new plotter("complex_zeta");
        // new plotter("complex_sin");
        // new plotter("complex_tan");
        // new plotter("complex_cot");
        // new plotter("complex_sec");
        // new plotter("complex_csc");
        // new plotter("complex_sinh");
        // new plotter("complex_csch");
        new plotter("complex_beta");
        */
        // Fourier series
        /*
        // new plotter("sawtooth_wave");
        // new plotter("eisenstein_s", 5);
        */
        // Big Complex numbers
        /*
        // BigComplexNumbers c1 = new BigComplexNumbers(new BigDecimal(1), new BigDecimal(-5));
        // c1.display();
        // BigComplexNumbers c2 = new BigComplexNumbers(new BigDecimal(-0.5), new BigDecimal(2));
        // c2.display();
        // System.out.println("");
        // BigComplexNumbers o1 = new BigComplexNumbers(); // Add
        // o1 = c1.add(c2); o1.display(); 
        // BigComplexNumbers o2 = new BigComplexNumbers(); // Sub
        // o2 = c1.sub(c2); o2.display();
        // BigComplexNumbers o3 = new BigComplexNumbers(); // Mul
        // o3 = c1.mul(c2); o3.display();
        // BigComplexNumbers o4 = new BigComplexNumbers(); // Div
        // o4 = c1.div(c2); o4.display();
        // BigComplexNumbers o5 = new BigComplexNumbers(); // Ln
        // o5 = c1.ln(); o5.display();
        // BigComplexNumbers o6 = new BigComplexNumbers(); // Exp
        // o6 = c1.exp(); o6.display();
        // BigComplexNumbers o7 = new BigComplexNumbers(); // Sin
        // o7 = c1.sin(); o7.display();
        // BigComplexNumbers o8 = new BigComplexNumbers(); // Cos
        // o8 = c1.cos(); o8.display();
        // BigComplexNumbers o9 = new BigComplexNumbers(); // Pow
        // o9 = c1.pow(c2); o9.display();
        */
        // Big Complex functions
        BigComplexNumbers i1 = new BigComplexNumbers(new BigDecimal(2), new BigDecimal(1));
        // complex_stieltjes_constant stieltjes = new complex_stieltjes_constant();
        // stieltjes._stieltjes_constant(1, i1).display();
        
    }
}
