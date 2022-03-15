package lib.java.number_theory;

import java.math.BigDecimal;
import lib.java.basic.BigDecimalMath;


/**
 * <h3>Additional function for Number theory file</h3>
 */
public class additional_numberTheory {
    /**
     * <h3>Function for checking if numbers are realively prime</h3>
     * This function outputs boolean value and for bigger integers it can take up huge amount of time.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Relatively_prime}
     */
    public static boolean relatively_prime(BigDecimal a, BigDecimal b) {
        BigDecimal small = new BigDecimal(0);
        BigDecimal big = new BigDecimal(0);
        if (a.compareTo(b) == 0) {
            return false;
        } else if (a.compareTo(b) > 0) {
            big = a; small = b;
        } else {
            big = b; small = a;
        }
        for (BigDecimal i = BigDecimalMath.TWO; i.compareTo(small) <= 0; i = i.add(BigDecimal.ONE)) {
            if (small.remainder(i).compareTo(BigDecimal.ZERO) == 0) {
                if (big.remainder(i).compareTo(BigDecimal.ZERO) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    // ----------------------------------------------------
}
