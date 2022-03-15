package lib.java.fourier_function;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lib.java.basic.BigDecimalMath;


/**
 * @author Petr Kučera
 * @version 0.0.1
 * @since 20222-03-14
 */
public class BigDecimal_fourierFunction {
    // ----------------------------------------------------
    /**
     * <h3>Sawtooth function - NOT WORKING</h3>
     * This is special case of fourier series. This program is made with general definition
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Sawtooth_wave}
     */
    public static BigDecimal sawtooth_wave(BigDecimal t) {
        BigDecimal ans = new BigDecimal(0);
        if (((t.subtract(BigDecimalMath.HALF)).setScale(0, RoundingMode.HALF_UP)).compareTo(t.subtract(BigDecimalMath.HALF)) != 0) {
            ans = BigDecimalMath.TWO.multiply(t.subtract((t.add(BigDecimalMath.HALF)).setScale(0, RoundingMode.FLOOR)));
        } else {
            return null;
        }
        // System.out.println((t.add(BigDecimalMath.HALF)).setScale(0, RoundingMode.DOWN));
        return ans.setScale(16, RoundingMode.HALF_UP);
    }
    // ----------------------------------------------------
    /**
     * <h3>Dedekind sum</h3>
     * This function is certain product of sawtooth function. This algorithm is defined for a = 1. This function works only for numbers that are coprime and
     * greater than one.
     * <p>
     * It should have accuracy around 10^(-50) and time of execution depends on how big are the input values.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Dedekind_sum}
     */
    public static BigDecimal dedekind_sum(BigDecimal b, BigDecimal c) {
        BigDecimal ans = new BigDecimal(0);
        if (b.compareTo(BigDecimal.ZERO) > 0 && c.compareTo(BigDecimal.ZERO) > 0) {
            for (BigDecimal n = BigDecimal.ONE; n.compareTo(c.subtract(BigDecimal.ONE)) <= 0; n = n.add(BigDecimal.ONE)) {
                BigDecimal arg1 = (BigDecimalMath.PI.multiply(n)).divide(c, 100, RoundingMode.HALF_UP);
                BigDecimal arg2 = (BigDecimalMath.PI.multiply(n.multiply(b))).divide(c, 100, RoundingMode.HALF_UP);
                ans = ans.add(BigDecimalMath.cot(arg1).multiply(BigDecimalMath.cot(arg2)));
            }
            return ans.divide((new BigDecimal(4)).multiply(c), 100, RoundingMode.HALF_UP).setScale(50, RoundingMode.HALF_UP);
        } else {
            if (b.compareTo(BigDecimal.ZERO) == 0 || c.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            } else {
                return null;
            }
        }
    }
    // ----------------------------------------------------
}
