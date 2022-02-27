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
 * Still I tried to make them efficient as possible. Their precision is written in their description, but with larger number it become more unprecise. Those function were tested from real values
 * <-5;5> and imaginary values <-5;5>, so it works good on smaller values.
 * <p>
 * <b>Basic usage of opearions and function is: </b>
 * <p>
 *  - If you need only one argument or use one argument as base of function (like sine(x), cosine(x), log(x) with base b, etc), you write it like this: {@code ComplexNumber.log(a)}, where <i>a</i> is complex number or {@code ComplexNumber.log(x, b)}, where <i>x</i> is complex number and <i>b</i> is base (can also be complex).
 * <p>
 *  - If you "edit" one complex number with another (like adding, subtracting, etc), you write it like this: {@code a.add(b)}, where <i>a</i> and <i>b</i> are complex numbers.
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
    public static final ComplexNumber ZERO = new ComplexNumber();
    // ----------------------------------------------------
    /**
     * <h3>One value of complex number</h3>
     * Returns real part as <b>one</b> and imaginary part as <b>zero</b>.
     */
    public static final ComplexNumber ONE = new ComplexNumber(1, 0);
    // ----------------------------------------------------
    /**
     * <h3>Minus one value of complex number</h3>
     * Returns real part as <b>-1</b> and imaginary part as <b>0</b>.
     */
    public static final ComplexNumber MINUSONE = new ComplexNumber(-1, 0);
    // ----------------------------------------------------
    /**
     * <h3>I value of complex number</h3>
     * Returns real part as <b>zero</b> and imaginary part as <b>one</b>.
     */
    public static final ComplexNumber I = new ComplexNumber(0, 1);
    // ----------------------------------------------------
    /**
     * <h3>PI/2 value of complex number</h3>
     * Returns real part as <b>pi/2</b> and imaginary part as <b>one</b>
     */
    public static final ComplexNumber HALFPI = new ComplexNumber(BigDecimalMath.PI.divide(BigDecimalMath.TWO, 1000, RoundingMode.HALF_UP));
    // ----------------------------------------------------
    /**
     * <h3>Half I calue of complex number </h3>
     * Returns real part as <b>zero</b> and imaginary part as <b>i/2</b>
     */
    public static final ComplexNumber HALFI = new ComplexNumber(0, 0.5);
    // ----------------------------------------------------
    /**
     * <h3>Polar conversion</h3>
     * Sets values for polar complex interpretaion. You can return those values with {@code .R}, which is radius, and {@code .PHI}, which is angle.
     */
    public void polar_conversion() {
        // R value
        R = (REAL.pow(2).add(IMG.pow(2))).sqrt(new MathContext(50));
        // PHI value
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
        // Check if polar values are created or not
        // - If not, it will call function that create them
        if (R == null || PHI == null) {
            this.polar_conversion();
        }
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
    /**
     * <h3>Additionfunction for complex numbers</h3>
     * Function that adds two complex numbers.
     * <p>
     * Adding works simply:  {@code (a+bi)+(x+yi) = a+bi+x+yi = (a+x)+(bi+yi)}
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Addition_and_subtraction}
     */
    public ComplexNumber add(ComplexNumber b) {
        ComplexNumber ans = new ComplexNumber();
        ans.REAL = REAL.add(b.REAL);
        ans.IMG = IMG.add(b.IMG);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Subtraction function for complex numbers</h3>
     * Function that subtracts two complex numbers.
     * <p>
     * Subtracting works simply: {@code (a+bi)-(x+y1) = a+bi-x-yi = (a-x)+(bi-yi)}
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Addition_and_subtraction}
     */
    public ComplexNumber subtract(ComplexNumber b) {
        ComplexNumber ans = new ComplexNumber();
        ans.REAL = REAL.subtract(b.REAL);
        ans.IMG = IMG.subtract(b.IMG);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Multiplication function for complex numbers</h3>
     * Function that multiplies two complex numbers.
     * <p>
     * Multiplication works like this: {@code (a+bi)*(x+yi) = ax+ayi+bix-by = (ax-by)+(ayi+bxi)}
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Multiplication_and_square}
     */
    public ComplexNumber multiply(ComplexNumber b) {
        ComplexNumber ans = new ComplexNumber();
        ans.REAL = (REAL.multiply(b.REAL)).subtract(IMG.multiply(b.IMG));
        ans.IMG = (REAL.multiply(b.IMG)).add(IMG.multiply(b.REAL));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Division function for complex numbers</h3>
     * Function that divides one complex number and one non-zero complex number.
     * <p>
     * Division works like this: {@code (a+bi)/(x+yi) = ((ax+by)+(bx-ay)i)/(x^2+y^2)}. It's accuracy is around 1x10^(-50).
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Reciprocal_and_division}
     */
    public ComplexNumber divide(ComplexNumber b) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        if (b.REAL.compareTo(BigDecimal.ZERO) == 0 && b.IMG.compareTo(BigDecimal.ZERO) == 0) {
            return null;
        }
        ans.REAL = ((REAL.multiply(b.REAL)).add(IMG.multiply(b.IMG))).divide((b.REAL.pow(2)).add(b.IMG.pow(2)), 50, RoundingMode.HALF_UP);
        ans.IMG = ((IMG.multiply(b.REAL)).subtract(REAL.multiply(b.IMG))).divide((b.REAL.pow(2)).add(b.IMG.pow(2)), 50, RoundingMode.HALF_UP);
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Squaring of complex number</h3>
     * Function that squares one complex number.
     * <p>
     * Squaring works simply like this: {@code (a+bi)^2 = a^2+2abi-b^2 = (a^2-b^2)+2abi}
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Multiplication_and_square}
     */
    public static ComplexNumber square(ComplexNumber a) {
        ComplexNumber ans = new ComplexNumber();
        ans.REAL = (a.REAL.pow(2)).subtract(a.IMG.pow(2));
        ans.IMG = ((new BigDecimal(2)).multiply(a.REAL.multiply(a.IMG)));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Square root of complex number</h3>
     * Function that makes square root of complex number.
     * <p>
     * Square root work like this: {@code (a+bi)^(1/2) = m+ni }, where {@code m = ((a+(a^2+b^2)^(1/2))/2)^(1/2)}  and {@code n = sgn(b)*((-a+(a^2+b^2)^(1/2))/2)^(1/2)}.
     * It's accuracy is around 1x10^(-50) and time of exectuion is 5ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Square_root}
     */
    public static ComplexNumber sqrt(ComplexNumber a) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans.REAL = ((a.REAL.add(((a.REAL.pow(2)).add(a.IMG.pow(2))).sqrt(new MathContext(50)))).divide(new BigDecimal(2), 50, RoundingMode.HALF_UP)).sqrt(new MathContext(50));
        ans.IMG = (BigDecimalMath.sign(a.IMG)).multiply(((((new BigDecimal(-1)).multiply(a.REAL)).add(((a.REAL.pow(2)).add(a.IMG.pow(2))).sqrt(new MathContext(50)))).divide(new BigDecimal(2), 50, RoundingMode.HALF_UP)).sqrt(new MathContext(50)));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Exponential function</h3>
     * Function that returns exponential value of complex number. I used functional equation with Euler's formula.
     * <p>
     * Exponential function works like this: {@code e^(x+yi) = e^x*cos(y)+e^x*sin(y)i}. It's accuracy is around 1x10^(-40) and time of exectuion is 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Exponential_function}
     */
    public static ComplexNumber exp(ComplexNumber a) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans.REAL = BigDecimalMath.exp(a.REAL).multiply(BigDecimalMath.cos(a.IMG));
        ans.IMG = BigDecimalMath.exp(a.REAL).multiply(BigDecimalMath.sin(a.IMG));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Natural logarithm</h3>
     * Function that returns natural logarithm of complex number. I caluclate it with polar form of complex number.
     * <p>
     * Natural logarithm works like this: {@code z = r(cos(phi)+sin(phi)i) ; ln(z) = ln(r) + phi*i}. Its precision should be around 1x10^(-30) and execution time around 400ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Complex_logarithm}
     */
    public static ComplexNumber log(ComplexNumber a) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        // Check if polar values are created or not
        // - If not, it will call function that create them
        if (a.R == null || a.PHI == null) {
            a.polar_conversion();
        }
        ans.REAL = BigDecimalMath.log(a.R);
        ans.IMG = a.PHI;
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Logarithm of some base</h3>
     * Function that returns logarithm of complex number with base of another complex number. 
     * <p>
     * Logarithm with other base work like this: {@code log(x, b) = log(x)/log(b)}, <i>b</i> is base of this logarithm. Its precision is about 1x10^(-15) and time of execution is 400ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_logarithm#Logarithms_to_other_bases}
     */
    public static ComplexNumber log(ComplexNumber x, ComplexNumber b) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans = log(x).divide(log(b));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Power function</h3>
     * Function that returns complex number to the power of another.
     * <p>
     * Power function works like this: {@code x^z = e^(z*ln(x))}. Its precision should be around 1x10^(-15) and execution time is around 260ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Complex_number#Exponentiation}
     */
    public ComplexNumber pow(ComplexNumber b) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans = exp(b.multiply(log(new ComplexNumber(REAL, IMG))));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Absolute power</h3>
     * Function that return absolute power of complex number.
     * <p>
     * Absolute power is radius of complex number.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Absolute_value#Complex_numbers}
     */
    public static ComplexNumber abs(ComplexNumber z) {
        // Check if polar values are created or not
        // - If not, it will call function that create them
        // // long startTime = System.nanoTime();
        if (z.R == null || z.PHI == null) {
            z.polar_conversion();
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return new ComplexNumber(z.R);
    }
    // ----------------------------------------------------
    /**
     * <h3>Sign function</h3>
     * Sign function is for complex numbers works like this: {@code sgn(z) = z/|z|}
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Sign_function#Complex_signum}
     */
    public static ComplexNumber sgn(ComplexNumber z) {
        return z.divide(abs(z));
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex sine function</h3>
     * Sine function for complex numbers.
     * <p>
     * It's precision is around 1x10^(-20) and execturion time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Sine_and_cosine#Complex_arguments}
     */
    public static ComplexNumber sin(ComplexNumber z) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans.REAL = (BigDecimalMath.sin(z.REAL)).multiply(BigDecimalMath.cosh(z.IMG));
        ans.IMG = (BigDecimalMath.cos(z.REAL)).multiply(BigDecimalMath.sinh(z.IMG));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex cosine function</h3>
     * Cosine function for complex numbers.
     * <p>
     * It's precision is around 1x10^(-20) and execturion time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Sine_and_cosine#Complex_arguments}
     */
    public static ComplexNumber cos(ComplexNumber z) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans.REAL = (BigDecimalMath.cos(z.REAL)).multiply(BigDecimalMath.cosh(z.IMG));
        ans.IMG = (BigDecimalMath.MINUSONE).multiply((BigDecimalMath.sin(z.REAL)).multiply(BigDecimalMath.sinh(z.IMG)));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex tangent function</h3>
     * Tangent function for complex numbers. I used the unit circle definition to compute this.
     * <p>
     * It's precision is around 1x10^(-20) and execturion time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Trigonometric_functions#Unit-circle_definitions}
     */
    public static ComplexNumber tan(ComplexNumber z) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans = sin(z).divide(cos(z));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex tangent function</h3>
     * Tangent function for complex numbers. I used the unit circle definition to compute this.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Trigonometric_functions#Unit-circle_definitions}
     */
    public static ComplexNumber cot(ComplexNumber z) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans = cos(z).divide(sin(z));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex secant function</h3>
     * Secant function for complex numbers. I used the unit circle definition to compute this.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Trigonometric_functions#Unit-circle_definitions}
     */
    public static ComplexNumber sec(ComplexNumber z) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans = ONE.divide(cos(z));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex cosecant function</h3>
     * Cosecant function for complex numbers. I used the unit circle definition to compute this.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Trigonometric_functions#Unit-circle_definitions}
     */
    public static ComplexNumber csc(ComplexNumber z) {
        ComplexNumber ans = new ComplexNumber();
        // // long startTime = System.nanoTime();
        ans = ONE.divide(sin(z));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arcsine function</h3>
     * Arcsine function for complex numbers. I used logarithmic form to compute this.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_trigonometric_functions#Logarithmic_forms}
     */
    public static ComplexNumber arcsin(ComplexNumber z) {
        // // long startTime = System.nanoTime();
        ComplexNumber inside = (sqrt(ONE.subtract(square(z))).subtract(I.multiply(z)));
        ComplexNumber ans = I.multiply(log(inside));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return (ans);
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arccosine function</h3>
     * Arccosine function for complex numbers. I used logarithmic form to compute this.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_trigonometric_functions#Logarithmic_forms}
     */
    public static ComplexNumber arccos(ComplexNumber z) {
        ComplexNumber ans = HALFPI.subtract(arcsin(z));
        ans.REAL = ans.REAL.setScale(50, RoundingMode.HALF_UP);
        ans.IMG = ans.IMG.setScale(50, RoundingMode.HALF_UP);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arctangent function</h3>
     * Arctangent function for complex numbers. I used logarithmic form to compute this.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_trigonometric_functions#Logarithmic_forms}
     */
    public static ComplexNumber arctan(ComplexNumber z) {
        // // long startTime = System.nanoTime();
        ComplexNumber inside = (I.subtract(z)).divide(I.add(z));
        ComplexNumber ans = MINUSONE.multiply(HALFI.multiply(log(inside)));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arccotangent function</h3>
     * Arccotangent function for complex numbers. I used logarithmic form to compute this.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_trigonometric_functions#Logarithmic_forms}
     */
    public static ComplexNumber arccot(ComplexNumber z) {
        // // long startTime = System.nanoTime();
        ComplexNumber inside = (z.add(I)).divide(z.subtract(I));
        ComplexNumber ans = MINUSONE.multiply(HALFI.multiply(log(inside)));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arcsecant function</h3>
     * Arcsecant function for complex numbers. I used logarithmic form to compute this.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_trigonometric_functions#Logarithmic_forms}
     */
    public static ComplexNumber arcsec(ComplexNumber z) {
        ComplexNumber ans = HALFPI.subtract(arccsc(z));
        ans.REAL = ans.REAL.setScale(50, RoundingMode.HALF_UP);
        ans.IMG = ans.IMG.setScale(50, RoundingMode.HALF_UP);
        return (ans);
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arccosecant function</h3>
     * Arccosecant function for complex numbers. I used logarithmic form to compute this.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_trigonometric_functions#Logarithmic_forms}
     */
    public static ComplexNumber arccsc(ComplexNumber z) {
        // // long startTime = System.nanoTime();
        ComplexNumber inside = (sqrt(ONE.subtract(ONE.divide(square(z)))).subtract(I.divide(z)));
        ComplexNumber ans = I.multiply(log(inside));
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex sinh function</h3>
     * Hyperbolic sine function for complex numbers. I used definition with trigonometric function.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Hyperbolic_functions#Complex_trigonometric_definitions}
     */
    public static ComplexNumber sinh(ComplexNumber z) {
        ComplexNumber ans = MINUSONE.multiply(I.multiply(sin(I.multiply(z))));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex cosh function</h3>
     * Hyperbolic cosine function for complex numbers. I used definition with trigonometric function.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Hyperbolic_functions#Complex_trigonometric_definitions}
     */
    public static ComplexNumber cosh(ComplexNumber z) {
        ComplexNumber ans = cos(I.multiply(z));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex tanh function</h3>
     * Hyperbolic tangent function for complex numbers. I used definition with trigonometric function.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Hyperbolic_functions#Complex_trigonometric_definitions}
     */
    public static ComplexNumber tanh(ComplexNumber z) {
        ComplexNumber ans = MINUSONE.multiply(I.multiply(tan(I.multiply(z))));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex coth function</h3>
     * Hyperbolic cotangent function for complex numbers. I used definition with trigonometric function.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Hyperbolic_functions#Complex_trigonometric_definitions}
     */
    public static ComplexNumber coth(ComplexNumber z) {
        ComplexNumber ans = I.multiply(cot(I.multiply(z)));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex sech function</h3>
     * Hyperbolic secant function for complex numbers. I used definition with trigonometric function.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Hyperbolic_functions#Complex_trigonometric_definitions}
     */
    public static ComplexNumber sech(ComplexNumber z) {
        ComplexNumber ans = sec(I.multiply(z));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex csch function</h3>
     * Hyperbolic cosecant function for complex numbers. I used definition with trigonometric function.
     * <p>
     * It's precision is around 1x10^(-20) and execution time is around 30ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Hyperbolic_functions#Complex_trigonometric_definitions}
     */
    public static ComplexNumber csch(ComplexNumber z) {
        ComplexNumber ans = I.multiply(csc(I.multiply(z)));
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arsinh function</h3>
     * Inverse hyperbolic sine function for complex numbers. I used logarithmic definition.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms-
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Principal_values_in_the_complex_plane}
     */
    public static ComplexNumber arcsinh(ComplexNumber z) {
        ComplexNumber ans = z.add(sqrt(square(z).add(ONE)));
        return log(ans);
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arcosh function</h3>
     * Inverse hyperbolic cosine function for complex numbers. I used logarithmic definition.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms-
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Principal_values_in_the_complex_plane}
     */
    public static ComplexNumber arccosh(ComplexNumber z) {
        ComplexNumber ans = z.add(sqrt(z.add(ONE)).add(sqrt(z.subtract(ONE))));
        return log(ans);
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex artanh function</h3>
     * Inverse hyperbolic tangent function for complex numbers. I used logarithmic definition.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms-
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Principal_values_in_the_complex_plane}
     */
    public static ComplexNumber arctanh(ComplexNumber z) {
        ComplexNumber ans = (z.add(ONE)).divide(ONE.subtract(z));
        return log(ans).divide(new ComplexNumber(2, 0));
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arcoth function</h3>
     * Inverse hyperbolic cotangent function for complex numbers. I used logarithmic definition.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms-
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Principal_values_in_the_complex_plane}
     */
    public static ComplexNumber arccoth(ComplexNumber z) {
        ComplexNumber ans = (z.add(ONE)).divide(z.subtract(ONE));
        return log(ans).divide(new ComplexNumber(2, 0));
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arcsch function</h3>
     * Inverse hyperbolic cosecant function for complex numbers. I used logarithmic definition.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms-
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Principal_values_in_the_complex_plane}
     */
    public static ComplexNumber arccsch(ComplexNumber z) {
        ComplexNumber ans = ((ONE.divide(z)).add(sqrt((ONE.divide(square(z))).add(ONE))));
        return log(ans);
    }
    // ----------------------------------------------------
    /**
     * <h3>Complex arsech function</h3>
     * Inverse hyperbolic secant function for complex numbers. I used logarithmic definition.
     * <p>
     * It's precision is around 1x10^(-30) and execution time is around 500ms-
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Principal_values_in_the_complex_plane}
     */
    public static ComplexNumber arcsech(ComplexNumber z) {
        ComplexNumber ans = ((ONE.divide(z)).add(sqrt((ONE.divide(z)).add(ONE)).multiply(sqrt((ONE.divide(z)).subtract(ONE)))));
        return log(ans);
    }
    // ----------------------------------------------------
}
