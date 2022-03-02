
import java.math.BigDecimal;

import lib.java.functions.BigDecimalFunction;
import lib.java.numbers.BigDecimalMath;
import lib.java.numbers.ComplexNumber;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        // // BigDecimalMath
        // Database tests
        System.out.println(BigDecimalMath.cos(new BigDecimal(5)));
        // // Complex numbers
        /*
        ComplexNumber n1 = new ComplexNumber(5, 4);
        ComplexNumber n2 = new ComplexNumber(2, 1);
        */
        // n1.display();
        // n1.b_display();
        // ----------------------------------------------------
        /*
        (n1.add(n2)).display(); // Addition
        (n1.subtract(n2)).display(); // Subtraction
        (n1.multiply(n2)).display(); // Multiplication
        (n1.divide(n2)).display(); // Division
        (ComplexNumber.square(n1)).display(); // Square
        (ComplexNumber.sqrt(n1)).display(); // Square root
        (ComplexNumber.exp(n1)).display(); // Exponentional function
        (ComplexNumber.log(n1)).display(); // Natural logarithm
        (n1.pow(n2)).display(); // Power
        (ComplexNumber.log(n2, n1)).display(); // Logarithm with other base
        (ComplexNumber.abs(n1)).display(); // Absolute value
        (ComplexNumber.sgn(n1)).display(); // Complex sign
        */
        // ----------------------------------------------------
        /*
        // Trigonometric functions
        (ComplexNumber.sin(n1)).display(); // Sine
        (ComplexNumber.cos(n1)).display(); // Cosine
        (ComplexNumber.tan(n1)).display(); // Tangent
        (ComplexNumber.cot(n1)).display(); // Cotangent
        (ComplexNumber.sec(n1)).display(); // Secant
        (ComplexNumber.csc(n1)).display(); // Cosecant
        */
        /*
        // Inverse trigonometric functions
        (ComplexNumber.arcsin(n1)).display(); // Arcsine
        (ComplexNumber.arccos(n1)).display(); // Arccosine
        (ComplexNumber.arctan(n1)).display(); // Atangent
        (ComplexNumber.arccot(n1)).display(); // Acotangent
        (ComplexNumber.arcsec(n1)).display(); // Asecant
        (ComplexNumber.arccsc(n1)).display(); // Acosecant
        */
        /*
        // Hyperbolic functions
        (ComplexNumber.sinh(n1)).display(); // Sinh
        (ComplexNumber.cosh(n1)).display(); // Cosh
        (ComplexNumber.tanh(n1)).display(); // Tanh
        (ComplexNumber.coth(n1)).display(); // Coth
        (ComplexNumber.sech(n1)).display(); // Sech
        (ComplexNumber.csch(n1)).display(); // Csch
        */
        /*
        // Inverse hyperbolic function
        (ComplexNumber.arcsinh(n1)).display(); // Arsinh
        (ComplexNumber.arccosh(n1)).display(); // Arcosh
        (ComplexNumber.arctanh(n1)).display(); // Artanh
        (ComplexNumber.arccoth(n1)).display(); // Arcoth
        (ComplexNumber.arcsech(n1)).display(); // Arsech
        (ComplexNumber.arccsch(n1)).display(); // Arcsch
        */
        // System.out.println(BigDecimalFunction.sigma(new BigDecimal(0.5), new BigDecimal(5)));
        // System.out.println(BigDecimalFunction.totient_function(new BigDecimal(4)));

        // File on different disk test
        /*
        File file = new File("D:\\Github\\..projects\\JavaMath\\data\\math_data\\lol.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
        br.close();
        */
    }
}
