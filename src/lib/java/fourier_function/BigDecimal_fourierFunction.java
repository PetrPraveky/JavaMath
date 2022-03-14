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
     * <h3>Sawtooth function</h3>
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
     * This function is certain product of sawtooth function. This algorithm is defined for a = 1.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Dedekind_sum}
     */
    public static BigDecimal dedekind_sum(BigDecimal b, BigDecimal c) {
        BigDecimal ans = new BigDecimal(0);
        if (b.compareTo(BigDecimal.ZERO) > 0 && c.compareTo(BigDecimal.ZERO) > 0) {
            return null;
        } else {
            for (BigDecimal n = BigDecimal.ONE; n.compareTo(c.subtract(BigDecimal.ONE)) < 0; n = n.add(BigDecimal.ONE)) {

            }
            return null;
        }
    }
    // ----------------------------------------------------
}
