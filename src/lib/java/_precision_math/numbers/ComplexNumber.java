package lib.java._precision_math.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;

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
     * {@code BigInteger} with <b>{@code .BigIntegerValue()}</b> or to {@code int} with <b>{@code .intValue()}</b>.
     */
    public BigDecimal IMG;
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
}
