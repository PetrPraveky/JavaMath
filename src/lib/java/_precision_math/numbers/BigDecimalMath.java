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
     * <h3>Pi approximation to 50 decimal places multiplied by 2</h3>
     * This returns two times previous approximation
     */
    public static final BigDecimal TWOPI = PI.multiply(new BigDecimal(2));
    // ----------------------------------------------------
    /**
     * <h3>Minus one value for BigDecimal</h3>
     */
    public static final BigDecimal MINUSONE = new BigDecimal(-1);
    // ----------------------------------------------------
    /**
     * <h3>Two value for BigDecimal</h3>
     */
    public static final BigDecimal TWO = new BigDecimal(2);
    // ----------------------------------------------------
    /**
     * <h3>Sine function</h3>
     * Sine approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Trigonometric_functions}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 10ms.
     */
    public static BigDecimal sin(BigDecimal x) {
        // Taylor series approximation
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(25)) <= 0; n = n.add(BigDecimal.ONE)) {
            BigDecimal numerator = MINUSONE.pow(n.intValue());
            BigDecimal denominator = factorial((TWO.multiply(n)).add(BigDecimal.ONE));
            ans = ans.add((numerator.divide(denominator, 1000, RoundingMode.HALF_UP)).multiply(x.pow(((TWO.multiply(n)).add(BigDecimal.ONE)).intValue())));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans.setScale(50, RoundingMode.HALF_UP);
    }
    // ----------------------------------------------------
    /**
     * <h3>Cosine function</h3>
     * Cosine approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Trigonometric_functions}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 10ms.
     */
    public static BigDecimal cos(BigDecimal x) {  
        // Taylor series approximation
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
            BigDecimal numerator = MINUSONE.pow(n.intValue());
            BigDecimal denominator = factorial(TWO.multiply(n));
            ans = ans.add((numerator.divide(denominator, 1000, RoundingMode.HALF_UP)).multiply(x.pow((TWO.multiply(n)).intValue())));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans.setScale(50, RoundingMode.HALF_UP);  
    }
    // ----------------------------------------------------
    /**
     * <h3>Arctangent for BigDecimal values</h3>
     * I used seventh-order approximation from this website: {@link https://www.researchgate.net/publication/258792323_Full_Quadrant_Approximations_for_the_Arctangent_Function_Tips_and_Tricks}
     * <p>
     * It's accuracy is around 2.212°*10^(-8)
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
     * <h3>Exponential function for BigDecimal</h3>
     * I used taylor series to approximate this. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Exponential_function}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 13ms.
     */
    public static BigDecimal exp(BigDecimal z) {
        BigDecimal ans = new BigDecimal(0);
        long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(150)) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add((z.pow(n.intValue())).divide(factorial(n), 50, RoundingMode.HALF_UP));
        }
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Factorial for BigDecimal
     * This function returns product of all positive integer less than or eqaul to {@code n}
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Factorial}
     */
    public static BigDecimal factorial(BigDecimal n) {
        BigDecimal ans = n;
        if (n.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        }
        if (n.compareTo(BigDecimal.ZERO) < 0) {
            return null;
        }
        for (BigDecimal k = new BigDecimal(1); k.compareTo(n) < 0; k = k.add(BigDecimal.ONE)) {
            ans = ans.multiply(n.subtract(k));
        }
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Sign function</h3>
     * Sign function for BigDecimal.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Sign_function}
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
