package lib.java.number_theory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

import lib.java.basic.BigDecimalMath;

/**
 * <h3>More complicated functions for BigDecimal</h3>
 * This program porvides some more complicated functions for Java module BigDecimal. Some of them are used in other programs, like ComplexFunction etc.
 * @author Petr Kučera
 * @version 0.0.1
 * @since 22.02.28
 */
public class BigDecimal_numberTheory {
    // ----------------------------------------------------
    /**
     * <h3>Sigma function</h3>
     * Function that returns sums of powers of divisors of given natural number. Also known as Divisor function.
     * <p>
     * This function is only defined for x = Real and n = Natural. Its precision is around 1x10^(-25) and time of execution 800 ms.
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
     * This function is defined for Natural numbers.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Euler%27s_totient_function}
     */
    public static BigDecimal totient_function(BigDecimal n) {
        BigDecimal ans = new BigDecimal(1);
        // // long startTime = System.nanoTime();
        // Check if number is Natural
        if (n.setScale(0, RoundingMode.HALF_UP).compareTo(n) != 0 || n.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        // Else do the function
        for (BigDecimal i = BigDecimal.ONE; i.compareTo(n) <= 0; i = i.add(BigDecimal.ONE)) {
            if ((n.remainder(i, new MathContext(50))).compareTo(BigDecimal.ZERO) == 0) {
                if (mobius_function(i).compareTo(BigDecimalMath.MINUSONE) == 0) {
                    ans = ans.multiply(BigDecimal.ONE.subtract(BigDecimal.ONE.divide(i, 50, RoundingMode.HALF_UP)));
                }
            }
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return n.multiply(ans).setScale(0, RoundingMode.HALF_UP);
    }
    // ----------------------------------------------------
    /**
     * <h3>Möbius function</h3>
     * Function that returns <i>1</i> if input is square-free positive integer with an even number of prime factors;
     * <i>0</i> if input is square-free positive integer with an odd number of prime factors - if input is prime;
     * <i>-1</i> if input has squared prime factor.
     * <p>
     * This function is defined for Natural numbers.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Möbius_function}
     */
    public static BigDecimal mobius_function(BigDecimal n) {
        // Check if number is Natural
        if (n.setScale(0, RoundingMode.HALF_UP).compareTo(n) != 0 || n.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        return kronecker_delta(small_prime_omega(n), big_prime_omega(n)).multiply(lioubille_function(n));
    }
    // ----------------------------------------------------
    /**
     * <h3>Kronecker delta</h3>
     * Function that return <i>0</i> if inputs are not equal and <i>1</i> if they are.
     * <p>
     * This function is defined for all numbers.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Kronecker_delta}
     */
    public static BigDecimal kronecker_delta(BigDecimal i, BigDecimal j) {
        if (i.compareTo(j) == 0) {
            return BigDecimal.ONE;
        } else {
            return BigDecimal.ZERO;
        }
    }
    // ---------------------------------------------------- 
    /**
     * <h3>Liouville function</h3>
     * Function that return 1 if input is product of even number of prime numbers and -1 if input is product of an odd number of primes.
     * <p>
     * This function is defined for Natural numbers.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Liouville_function}
     */
    public static BigDecimal lioubille_function(BigDecimal n) {
        // Check if number is Natural
        if (n.setScale(0, RoundingMode.HALF_UP).compareTo(n) != 0 || n.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        return BigDecimalMath.pow(BigDecimalMath.MINUSONE, big_prime_omega(n), true);
    }
    // ----------------------------------------------------
    /**
     * <h3>Prime omega function ω</h3>
     * Function that return amount of differnet prime divisors. This function is additive.
     * <p>
     * This function is defined for Natural numbers.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Prime_omega_function}
     */
    public static BigDecimal small_prime_omega(BigDecimal n) {
        // Check if number is Natural
        if (n.setScale(0, RoundingMode.HALF_UP).compareTo(n) != 0 || n.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        ArrayList<BigDecimal> ans_list = new ArrayList<BigDecimal>();
        if (n.compareTo(BigDecimal.ONE) <= 0) {
            return BigDecimal.ZERO;
        } else if (n.compareTo(BigDecimalMath.TWO) == 0) {
            return BigDecimal.ONE;
        }
        for (BigDecimal i = BigDecimalMath.TWO; i.compareTo(n) < 0; i = i.add(BigDecimal.ONE)) {
            while (n.remainder(i, new MathContext(50)).compareTo(BigDecimal.ZERO) == 0) {
                if (!ans_list.contains(i)) {
                    ans_list.add(i);
                }
                n = n.divide(i, 50, RoundingMode.HALF_UP);
            }
        }
        if (n.compareTo(BigDecimalMath.TWO) > 0) {
            ans_list.add(n);
        }
        return new BigDecimal(ans_list.size());
    }
    // ----------------------------------------------------
    /**
     * <h3>Prime omega function Ω</h3>
     * Function that returns amount of prime divisors. This function is completely additive.
     * <p>
     * This function is defined for Natural numbers.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Prime_omega_function}
     */
    public static BigDecimal big_prime_omega(BigDecimal n) {
        // Check if number is Natural
        if (n.setScale(0, RoundingMode.HALF_UP).compareTo(n) != 0 || n.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        ArrayList<BigDecimal> ans_list = new ArrayList<BigDecimal>();
        if (n.compareTo(BigDecimal.ONE) <= 0) {
            return BigDecimal.ZERO;
        } else if (n.compareTo(BigDecimalMath.TWO) == 0) {
            return BigDecimal.ONE;
        }
        for (BigDecimal i = BigDecimalMath.TWO; i.compareTo(n) < 0; i = i.add(BigDecimal.ONE)) {
            while (n.remainder(i, new MathContext(50)).compareTo(BigDecimal.ZERO) == 0) {
                ans_list.add(i);
                n = n.divide(i, 50, RoundingMode.HALF_UP);
            }
        }
        if (n.compareTo(BigDecimalMath.TWO) > 0) {
            ans_list.add(n);
        }
        return new BigDecimal(ans_list.size());
    }
    // ----------------------------------------------------
    /**
     * <h3>Prime counting function</h3>
     * Function that counts number of prime numbers less then or equal to some real number x.
     * <p>
     * It's computated approximatly, so the answers can be little bit off. Its time of execution is around 500ms. It's precision for numbers smaller than 40 is 
     * pretty good, but for larger inaccuracy grows and with very large numbers it is again pretty precise.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Prime-counting_function}
     */
    public static BigDecimal prime_counting(BigDecimal x) {
        // Check if number is Natural
        if (x.setScale(0, RoundingMode.HALF_UP).compareTo(x) != 0 || x.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        ans = x.divide(BigDecimalMath.log(x), 50, RoundingMode.HALF_UP);
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans.setScale(0, RoundingMode.DOWN);
    }
    // ----------------------------------------------------
    /**
     * <h3>Partition function</h3>
     * Function returns number of possible partition of natural number n.
     * <p>
     * It's time of execution changes depend on how large the number is. For larger numbers (more than )
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Partition_function_(number_theory)}
     */
    public static BigDecimal partition_function(BigDecimal n) {
        /*
        // p(0) is equal to 1
        if (n.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        }
        BigDecimal ans = new BigDecimal(0);
        // Recurrent function
        for (BigDecimal k = BigDecimal.ZERO; k.compareTo(n.subtract(BigDecimal.ONE)) <= 0; k = k.add(BigDecimal.ONE)) {
            ans = ans.add(sigma(BigDecimal.ONE, n.subtract(k)).multiply(partition_function(k)));
        }
        return ans.divide(n, 50, RoundingMode.HALF_UP);
        */
        BigDecimal ans = new BigDecimal(0);
        
    }
    // ----------------------------------------------------
}
