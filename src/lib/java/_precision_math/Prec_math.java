package lib.java._precision_math;

import lib.java._precision_math.numbers.ComplexNumber;

public class Prec_math {
    public static void main(String[] args) {
        ComplexNumber n1 = new ComplexNumber(5, 4);
        ComplexNumber n2 = new ComplexNumber(2, 1);
        // n1.display();
        // n1.b_display();
        // ----------------------------------------------------
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
    }
}
