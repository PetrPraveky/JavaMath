package lib.java._precision_math.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import lib.java._precision_math.numbers.BigDecimalMath;

/**
 * <h3>More complicated functions for BigDecimal</h3>
 * This program porvides some more complicated functions for Java module BigDecimal. Some of them are used in other programs, like ComplexFunction etc.
 * @author Petr Kučera
 * @version 0.0.1
 * @since 22.02.28
 */
public class BigDecimalFunction {
    // ----------------------------------------------------
    /**
     * <h3>Sigma function</h3>
     * Function that returns sums of powers of divisors of given natural number. Also known as Divisor function.
     * <p>
     * This function is only defined for x = Real and n = Natural. Its precision is around 1x10^(-40) and time of execution 800 ms.
     * Its time rapidly increase with more divisors of number.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Divisor_function#Formulas_at_prime_powers}
     */
    public static BigDecimal sigma(BigDecimal x, BigDecimal n) {
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        // Check if number is Natural
        if (n.setScale(0, RoundingMode.HALF_UP).compareTo(n) != 0 || n.compareTo(BigDecimal.ZERO) < 0) {
            return null;
        }
        for (BigDecimal i = BigDecimal.ONE; i.compareTo(n) <= 0; i = i.add(BigDecimal.ONE)) {
            if ((n.remainder(i, new MathContext(100))).compareTo(BigDecimal.ZERO) == 0) {
                ans = ans.add(BigDecimalMath.pow(i, x));
            }
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        // If ans has interger value
        if (ans.setScale(25, RoundingMode.HALF_UP).compareTo(ans.setScale(0, RoundingMode.HALF_UP)) == 0) {
            return ans.setScale(0, RoundingMode.HALF_UP);
        // Else returns its value
        } else {
            return ans.setScale(50, RoundingMode.HALF_UP);
        }
    }
    // ----------------------------------------------------
    /**
     * <h3>Eulers totient function</h3>
     * Fuction that returns sum of positive integer up to a given integer n that are relatively prime to n.
     * <p>
     * This function is defined for Natural numbers. Its precision is aorund _ and time of execution _ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Euler%27s_totient_function}
     */
    public static BigDecimal totient_function(BigDecimal n) {
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        // Check if number is Natural
        if (n.setScale(0, RoundingMode.HALF_UP).compareTo(n) != 0 || n.compareTo(BigDecimal.ZERO) < 0) {
            return null;
        }
        for (BigDecimal i = BigDecimal.ONE; i.compareTo(n) <= 0; i = i.add(BigDecimal.ONE)) {
            if (i.compareTo(BigDecimal.ONE) <= 0) {} else {
                for (BigDecimal j = new BigDecimal(2); j.compareTo(i) < 0; j = j.add(BigDecimal.ONE)) {
                    System.out.println(j);
                    if ((i.remainder(j, new MathContext(100))).compareTo(BigDecimal.ZERO) == 0) {
                        ans = ans.multiply(BigDecimal.ONE.subtract(BigDecimal.ONE.divide(j, 100, RoundingMode.HALF_UP)));
                    }
                }
            }
        }        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans.setScale(50, RoundingMode.HALF_UP);
    }
    // ----------------------------------------------------
}
