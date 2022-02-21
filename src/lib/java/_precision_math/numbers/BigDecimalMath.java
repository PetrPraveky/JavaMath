package lib.java._precision_math.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalMath {
    // ----------------------------------------------------
    /**
     * <h3>Pi approximation to 50 decimal places</h3>
     * I just copied this value from http://www.math.com/tables/constants/pi.htm
     */
    public static final BigDecimal PI = new BigDecimal(
        "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094330572703657595919530921861173819326117931051185480744623799627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051320005681271452635608277857713427577896091736371787214684409012249534301465495853710507922796892589235420199561121290219608640344181598136297747713099605187072113499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473035982534904287554687311595628638823537875937519577818577805321712268066130019278766111959092164201989"
    );
    // ----------------------------------------------------
    /**
     * <h3>Arctangent for BigDecimal values</h3>
     * I used approximation from this website: https://www.researchgate.net/publication/258792323_Full_Quadrant_Approximations_for_the_Arctangent_Function_Tips_and_Tricks
     * <p>
     * It's approximation is on
     */
    public static BigDecimal arctan(BigDecimal x) {
        BigDecimal[] A = new BigDecimal[] {
            new BigDecimal("0.6366198228040826"),
            new BigDecimal("2.1940566630059660"),
            new BigDecimal("4.1987334443688801")
        };
        BigDecimal[] B = new BigDecimal[] {
            new BigDecimal("3.4464210488063778"),
            new BigDecimal("6.9285856685452193"),
            new BigDecimal("9.5401599602587312")
        };
        BigDecimal PHI_num = (
            ((A[0].multiply(x.abs())).add(A[1].multiply((x.abs()).pow(2))).add(A[2].multiply((x.abs()).pow(3)))).add(((B[2].subtract(A[2]).multiply((x.abs()).pow(4))).add((B[1].subtract(A[1]).multiply((x.abs()).pow(5)))).add((B[0].subtract(A[0])).multiply((x.abs()).pow(6)))).add((x.abs()).pow(7)))
            );
        BigDecimal PHI_dec = (
            BigDecimal.ONE.add(B[0].multiply((x.abs()))).add(B[1].multiply((x.abs()).pow(2))).add(B[2].multiply((x.abs()).pow(3))).add(B[2].multiply((x.abs()).pow(4))).add(B[1].multiply((x.abs()).pow(5))).add(B[0].multiply((x.abs()).pow(6))).add((x.abs()).pow(7))
            );
        BigDecimal PHI = PHI_num.divide(PHI_dec, 50, RoundingMode.HALF_UP);
        BigDecimal ans = (PI.divide(new BigDecimal(2), 100, RoundingMode.HALF_UP)).multiply(sign(x)).multiply(PHI);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Sign function</h3>
     * Sign function for BigDecimal
     */
    public static BigDecimal sign(BigDecimal x) {
        if (x.compareTo(BigDecimal.ZERO) < 0) {
            return new BigDecimal(-1);
        } else if (x.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            return BigDecimal.ONE;
        }
    }
    // ----------------------------------------------------
}
