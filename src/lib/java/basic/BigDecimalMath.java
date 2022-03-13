package lib.java.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <h3>Basic math function for BigDecimal</h3>
 * This program contains some basic math function for Java module BigDecimal. Most of them are created just for my other package ComplexNumber.java.
 * <p>
 * Some of those calculations can take moew time than others, because some of used algorithms are more complicated.
 * Also this file contains some additional constants, that are not present in BigDecimal module (PI, E, -1, etc...)
 * <p>
 * All function are called as so: {@code BigDecimalMath.sin(x)}, where <i>x</i> is BigDecimal value.
 * <p>
 * All of commands are commented, so they can be easily understanded. If you want to see the full documentation, you can check it here: ---- in section: "BigDecimalMath".
 * <p>
 * @author Petr Kučera
 * @version 0.2.0
 * @since 2022-02-16
 */
public class BigDecimalMath {
    // ----------------------------------------------------
    /**
     * <h3>Main directory for saving values</h3>
     */
    // private static final String rootDir = "data/math_data/BigDecimalMath_data";
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
     * <h3>Pi approximation to 1000 decimal places</h3>
     * I just copied this value from {@link http://www.math.com/tables/constants/pi.htm}
     */
    public static final BigDecimal PI = new BigDecimal(
        "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094330572703657595919530921861173819326117931051185480744623799627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051320005681271452635608277857713427577896091736371787214684409012249534301465495853710507922796892589235420199561121290219608640344181598136297747713099605187072113499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473035982534904287554687311595628638823537875937519577818577805321712268066130019278766111959092164201989"
    );
    // ----------------------------------------------------
    /**
     * <h3>E approximation to 1000 decimal places</h3>
     * O just copird this value from {@link https://miniwebtool.com/first-n-digits-of-e/?number=1000}
     */
    public static final BigDecimal E = new BigDecimal(
        "2.7182818284590452353602874713526624977572470936999595749669676277240766303535475945713821785251664274274663919320030599218174135966290435729003342952605956307381323286279434907632338298807531952510190115738341879307021540891499348841675092447614606680822648001684774118537423454424371075390777449920695517027618386062613313845830007520449338265602976067371132007093287091274437470472306969772093101416928368190255151086574637721112523897844250569536967707854499699679468644549059879316368892300987931277361782154249992295763514822082698951936680331825288693984964651058209392398294887933203625094431173012381970684161403970198376793206832823764648042953118023287825098194558153017567173613320698112509961818815930416903515988885193458072738667385894228792284998920868058257492796104841984443634632449684875602336248270419786232090021609902353043699418491463140934317381436405462531520961836908887070167683964243781405927145635490613031072085103837505101157477041718986106873969655212671546889570350354"
    );
    // ----------------------------------------------------
    /**
     * <h3>Pi approximation to 50 decimal places multiplied by 2</h3>
     * This returns two times previous approximation
     */
    public static final BigDecimal TWOPI = PI.multiply(TWO);
    // ----------------------------------------------------
    /**
     * <h3>Pi/2 approximation to 50 decimal places multiplied by 2</h3>
     * This returns two times devided previous approximation
     */
    public static final BigDecimal HALFPI = PI.divide(TWO, 1000, RoundingMode.HALF_UP);
    // ----------------------------------------------------
    /**
     * <h3>-Pi/2 approximation to 50 decimal places multiplied by 2</h3>
     * This returns minus two times divided previous approximation
     */
    public static final BigDecimal MINHALFPI = MINUSONE.multiply(HALFPI);
    // ----------------------------------------------------
    /**
     * <h3>Sine function</h3>
     * Sine approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Trigonometric_functions}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 10ms.
     */
    public static BigDecimal sin(BigDecimal x, boolean... s) {
        BigDecimal ans = new BigDecimal(0);
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
            BigDecimal numerator = MINUSONE.pow(n.intValue());
            BigDecimal denominator = factorial((TWO.multiply(n)).add(BigDecimal.ONE));
            ans = ans.add((numerator.divide(denominator, 1000, RoundingMode.HALF_UP)).multiply(x.pow(((TWO.multiply(n)).add(BigDecimal.ONE)).intValue())));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        ans = ans.setScale(50, RoundingMode.HALF_UP);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Cosine function</h3>
     * Cosine approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Trigonometric_functions}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 10ms.
     */
    public static BigDecimal cos(BigDecimal x, boolean... s) {  
        BigDecimal ans = new BigDecimal(0);
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
            BigDecimal numerator = MINUSONE.pow(n.intValue());
            BigDecimal denominator = factorial(TWO.multiply(n));
            ans = ans.add((numerator.divide(denominator, 1000, RoundingMode.HALF_UP)).multiply(x.pow((TWO.multiply(n)).intValue())));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        ans = ans.setScale(50, RoundingMode.HALF_UP); 
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Arctangent for BigDecimal values</h3>
     * Arctangent approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Trigonometric_functions} and here: {@link https://proofwiki.org/wiki/Power_Series_Expansion_for_Real_Arctangent_Function}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 10ms.
     */
    public static BigDecimal arctan(BigDecimal x, boolean... s) {
        // If value is between 1 and -1
        BigDecimal ans = new BigDecimal(0);
        if (x.abs().compareTo(BigDecimal.ONE) <= 0) {
            for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
                BigDecimal numerator = MINUSONE.pow(n.intValue());
                BigDecimal denominator = (TWO.multiply(n)).add(BigDecimal.ONE);
                ans = ans.add((numerator.divide(denominator, 1000, RoundingMode.HALF_UP)).multiply(x.pow(((TWO.multiply(n)).add(BigDecimal.ONE)).intValue())));
            }
            // // long endTime = System.nanoTime();
            // // System.out.println((endTime-startTime)/1000000+"ms");
            ans = ans.setScale(50, RoundingMode.HALF_UP);
        } else {
            for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
                BigDecimal numerator = MINUSONE.pow(n.intValue());
                BigDecimal denominator = ((TWO.multiply(n)).add(BigDecimal.ONE)).multiply(x.pow(((TWO.multiply(n)).add(BigDecimal.ONE)).intValue()));
                ans = ans.add((numerator.divide(denominator, 1000, RoundingMode.HALF_UP)));
            }
            // // long endTime = System.nanoTime();
            // // System.out.println((endTime-startTime)/1000000+"ms");
            if (x.compareTo(BigDecimal.ONE) > 0) {
                ans = HALFPI.subtract(ans).setScale(50, RoundingMode.HALF_UP);
            } else if (x.compareTo(MINUSONE) < 0) {
                ans = MINHALFPI.subtract(ans).setScale(50, RoundingMode.HALF_UP);
            } else {
                ans = ans.setScale(50, RoundingMode.HALF_UP);
            }
        }
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Hyperbolic sine function for BigDecimal values</h3>
     * Hyperbolic sine approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Hyperbolic_functions}
     * <p>
     * It's precision is around 1x10^(-50) and execution time around 10ms.
     */
    public static BigDecimal sinh(BigDecimal x, boolean... s) {
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
            BigDecimal numerator = x.pow((2*(n.intValue())+1));
            BigDecimal denominator = factorial((TWO.multiply(n)).add(BigDecimal.ONE));
            ans = ans.add(numerator.divide(denominator, 1000, RoundingMode.HALF_UP));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        ans = ans.setScale(50, RoundingMode.HALF_UP);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Hyperbolic cosine function for BigDecimal values</h3>
     * Hyperbolic cosine approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Hyperbolic_functions}
     * <p>
     * It's precision is around 1x10^(-50) and execution time around 10ms.
     */
    public static BigDecimal cosh(BigDecimal x, boolean... s) {
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
            BigDecimal numerator = x.pow(2*(n.intValue()));
            BigDecimal denominator = factorial(TWO.multiply(n));
            ans = ans.add(numerator.divide(denominator, 1000, RoundingMode.HALF_UP));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        ans = ans.setScale(50, RoundingMode.HALF_UP);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Exponential function for BigDecimal</h3>
     * I used taylor series to approximate this. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Exponential_function}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 13ms.
     */
    public static BigDecimal exp(BigDecimal z, boolean... s) {
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(150)) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add((z.pow(n.intValue())).divide(factorial(n), 100, RoundingMode.HALF_UP));
        }
        ans = ans.setScale(50, RoundingMode.HALF_UP);
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    /**
     * <h3>Natural logarithm function for BigDecimal</h3>
     * I used modified Newton algorithm for computing this. You can read something here on wikipedia: {@link https://en.wikipedia.org/wiki/Natural_logarithm#High_precision}
     * <p>
     * It's precision is around 1x10^(-50) but time of execution is around 500ms and it depends on how large the input number is.
     */
    public static BigDecimal log(BigDecimal x, int... scale) {
        if (scale.length == 0) {
            scale = new int[] {50};
        }
        // // long startTime = System.nanoTime();
        BigDecimal ans = BigDecimal.ZERO;
        BigDecimal n = x; BigDecimal term;
        if (x.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        BigDecimal oldX;
        for (int i = 1; i<=1000000; i++) {
            BigDecimal eToX = exp(x);
            term = eToX.subtract(n).divide(eToX, scale[0], RoundingMode.HALF_UP);
            oldX = x;
            x = x.subtract(term);
            if (x.compareTo(oldX) == 0) {
                break;
            }
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        ans = x.setScale(50, RoundingMode.HALF_UP);
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Power function for BigDecimal</h3>
     * This function returns real power of BigDecimal number.
     * <p>
     * It has precision around 1x10^(-50) and time of execution is around 600ms.
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Exponentiation}
     */
    public static BigDecimal pow(BigDecimal b, BigDecimal x, boolean... isInt) {
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        if (isInt[0]) {
            ans = b.pow(x.intValue());
        } else {
            ans = exp(x.multiply(log(b)));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        // Sets number to integer thanks to some approximation errors
        BigDecimal epsilon = new BigDecimal(
            "0.00000000000000000000000000000000000000000000001"
        );
        if ((ans.subtract(ans.setScale(0, RoundingMode.HALF_UP)).abs()).compareTo(epsilon) <= 0) {
            ans = ans.setScale(0, RoundingMode.HALF_UP);
        } else {
            ans = ans.setScale(50, RoundingMode.HALF_UP);
        }
        return ans;
    }
    // ----------------------------------------------------
    /**
     * <h3>Factorial for BigDecimal
     * This function returns product of all positive integer less than or eqaul to {@code n}
     * <p>
     * You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Factorial}
     */
    public static BigDecimal factorial(BigDecimal n, boolean... s) {
        // If number is negative or fractional, it will return null
        if (n.compareTo(BigDecimal.ZERO) < 0 || n.compareTo(n.setScale(0, RoundingMode.HALF_UP)) != 0) {
            return null;
        }
        BigDecimal ans = n;
        if (n.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
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
