package lib.java._precision_math.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * <h3>Complex numbers and their calculations</h3>
 * This program provides most of calculations with complex numbers to large precision.
 * <p>
 * Some of those calculations can take more time than others, because some of them are more complicated.
 * Still I tried to make them efficient as possible.
 * <p>
 * All of commands that are here are commented, so they are easy to understand.
 * If you want to see the full documentation, you can check it here: ---- in section: "Complex numbers".
 * <p>
 * @author Petr Kučera
 * @version 0.0.1
 * @since 2022-02-16
 */
public class ComplexNumber {
    // ----------------------------------------------------
    /**
     * <h3>Real part of complex number</h3>
     * This part is set to be {@code BigDecimal} value.
     * You can change it to {@code double}</b> value with <b>{@code .doubleValue()}</b>, set it to {@code float} with <b>{@code .floatValue()}</b>,
     * {@code BigInteger} with <b>{@code .BigIntegerValue()}</b> or to {@code int} with <b>{@code .intValue()}</b>.
     */
    public BigDecimal REAL;
    // ----------------------------------------------------
    /**
     * <h3>Imaginary part of complex number</h3>
     * This part is set to be {@code BigDecimal} value.
     * You can change it to {@code double}</b> value with <b>{@code .doubleValue()}</b>, set it to {@code float} with <b>{@code .floatValue()}</b>,
     * {@code BigInteger} with <b>{@code .toBigInteger()}</b> or to {@code int} with <b>{@code .intValue()}</b>.
     */
    public BigDecimal IMG;
    // ----------------------------------------------------
    /**
     * <h3>Radius of complex number in polar complex plane</h3>
     * This part is set to be {@code BigDecimal} value.
     * You can change it to {@code double}</b> value with <b>{@code .doubleValue()}</b>, set it to {@code float} with <b>{@code .floatValue()}</b>,
     * {@code BigInteger} with <b>{@code .toBigInteger()}</b> or to {@code int} with <b>{@code .intValue()}</b>.
     */
    public BigDecimal R;
    // ----------------------------------------------------
    /**
     * <h3>Angle of complex number in polar complex plane</h3>
     * This part is set to be {@code BigDecimal} value.
     * You can change it to {@code double}</b> value with <b>{@code .doubleValue()}</b>, set it to {@code float} with <b>{@code .floatValue()}</b>,
     * {@code BigInteger} with <b>{@code .toBigInteger()}</b> or to {@code int} with <b>{@code .intValue()}</b>.
     */
    public BigDecimal PHI;
    // ----------------------------------------------------
    /**
     * <h3>Zero value of complex number</h3>
     * Returns both parts of complex number as <b>zero</b>.
     */
    public static ComplexNumber ZERO = new ComplexNumber();
    // ----------------------------------------------------
    /**
     * <h3>One value of complex number</h3>
     * Returns real part as <b>one</b> and imaginary part as <b>zero</b>
     */
    public static ComplexNumber ONE = new ComplexNumber(1, 0);
    // ----------------------------------------------------
    /**
     * <h3>I value of complex number</h3>
     * Returns real part as <b>zero</b> and imaginary part as <b>one</b>
     */
    public static ComplexNumber I = new ComplexNumber(0, 1);
    // ----------------------------------------------------
    /**
     * <h3>Empty constructor</h3>
     * Empty constructor for complex nubmers. Output will be determined as 0+0i, so real and imaginary part will be equal to {@code BigDecimal.ZERO}
     */
    // ----------------------------------------------------
        /**
     * <h3>Polar conversion</h3>
     * Sets values for polar complex interpretaion. You can return those values with {@code .R}, which is radius, and {@code .PHI}, which is angle.
     */
    public void polar_conversion() {
        // R value
        R = (REAL.pow(2).add(IMG.pow(2))).sqrt(new MathContext(50));
        // PHI value
        /*
        PHI = arg(x+yi) = if i == 0 and x != 0 ---> 0
                            if y != 0 or x > 0 -----> 2*arctan( y/( sqrt(x^2+y^2)+x) )
                            if x < 0 and y == 0 ----> pi
                            if x == 0 and y == 0 ---> undefined
        */
        if (REAL.compareTo(BigDecimal.ZERO) != 0 && IMG.compareTo(BigDecimal.ZERO) == 0) {
            PHI =  BigDecimal.ZERO;
        } else if (REAL.compareTo(BigDecimal.ZERO) > 0 || IMG.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal TWO = new BigDecimal(2);
            PHI = (
                TWO.multiply(BigDecimalMath.arctan(IMG.divide(R.add(REAL), 50, RoundingMode.HALF_UP)))
            );
            PHI = PHI.setScale(50, RoundingMode.HALF_UP);
        } else if (REAL.compareTo(BigDecimal.ZERO) < 0 && IMG.compareTo(BigDecimal.ZERO) == 0) {
            PHI = new BigDecimal(Math.PI);
            PHI = PHI.setScale(50, RoundingMode.HALF_UP);
        } else {
            PHI = null;
        }
    }
    public ComplexNumber() {
        REAL = BigDecimal.ZERO; IMG = BigDecimal.ZERO;
    }
    // ----------------------------------------------------
    /**
     * <h3>Constructor with both values as double</h3>
     * Constructor which sets real and imaginary values from double inputs <b>a</b> and <b>b</b>.
     */
    public ComplexNumber(double a, double b) {
        REAL = new BigDecimal(a); IMG = new BigDecimal(b);
    }
    // ----------------------------------------------------
    /**
     * <h3>Constructor with both values as BigDecimal</h3>
     * Constructor which sets real and imaginary values from BigDecimal input <b>a</b> and <b>b</b>.
     */
    public ComplexNumber(BigDecimal a, BigDecimal b) {
        REAL = a; IMG = b;
    }
    // ----------------------------------------------------
    /**
     * <h3>Constructor with both values as BigInteger</h3>
     * Constructor wich sets real and imaginary values from BigInteger input <b>a</b> and <b>b</b>.
     */
    public ComplexNumber(BigInteger a, BigInteger b) {
        REAL = new BigDecimal(a); IMG = new BigDecimal(b);
    }
    // ----------------------------------------------------
    /**
     * <h3>Constructor with both values as float</h3>
     * Constructor which sets real and imaginary values from float input <b>a</b> and <b>b</b>.
     */
    public ComplexNumber(float a, float b) {
        REAL = new BigDecimal(a); IMG = new BigDecimal(b);
    }
    // ----------------------------------------------------
    /**
     * <h3>Constructor with only real value as double</h3>
     * Constructor which sets real part to <b>r<b> and imaginary sets to <b>zero</b>.
     */
    public ComplexNumber(double r) {
        REAL = new BigDecimal(r); IMG = BigDecimal.ZERO;
    }
    // ----------------------------------------------------
    /**
     * <h3>Constructor with only real value as BigDecimal</h3>
     * Constructor which sets real part to <b>r<b> and imaginary sets to <b>zero</b>.
     */
    public ComplexNumber(BigDecimal r) {
        REAL = r; IMG = BigDecimal.ZERO;
    }
    // ----------------------------------------------------
    /**
     * <h3>Constructor with only real value as BigInteger</h3>
     * Constructor which sets real part to <b>r<b> and imaginary sets to <b>zero</b>.
     */
    public ComplexNumber(BigInteger r) {
        REAL = new BigDecimal(r); IMG = BigDecimal.ZERO;
    } 
    // ----------------------------------------------------
    /**
     * <h3>Constructor with only real value as float</h3>
     * Constructor which sets real part to <b>r<b> and imaginary sets to <b>zero</b>.
     */
    public ComplexNumber(float r) {
        REAL = new BigDecimal(r); IMG = BigDecimal.ZERO;
    }
    // ----------------------------------------------------
    /**
     * <h3>Display function of complex number</h3>
     * Function that print value of complex number to console.
     * <p>
     * It contains some basic editing like managing zeros and plus/minus.
     */
    public void display() {
        if (REAL.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(
                IMG.toString()+"i"
            );
            return;
        } else if (IMG.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(
                REAL.toString()
            );
            return;
        }
        if (IMG.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println(
                REAL.toString()+"-"+IMG.abs().toString()+"i"
            );
            return;
        } else {
            System.out.println(
                REAL.toString()+"+"+IMG.toString()+"i"
            );
            return;
        }
    }
    // ----------------------------------------------------
    /**
     * <h3>Pretier display function</h3>
     * Function that print value of complex number to console.
     * <p>
     * It contains some basic editing like managing zeros and plus/minus. Also it prints out prettier answers and more vivid values. I'll add some stuff like LaTeX print with simplification (like 1.414... = sqrt{2})
     */
    public void b_display() {
        String mp = "+";
        this.polar_conversion();
        if (IMG.compareTo(BigDecimal.ZERO) != 0 && REAL.compareTo(BigDecimal.ZERO) != 0) {
            if (IMG.compareTo(BigDecimal.ZERO) < 0) {
                mp = "-";
            }
            System.out.println(REAL+mp+IMG.abs()+"i");
            System.out.println("\nCartesian complex values: ");
            System.out.println("Real: "+REAL);
            System.out.println("Img:  "+IMG);
            System.out.println("\nPolar complex values: ");
            System.out.println("r:    "+R);
            System.out.println("Phi:  "+PHI+"rad");
        }
    }
    // ----------------------------------------------------
    
    // ----------------------------------------------------
}
