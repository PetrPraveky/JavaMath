package lib.java._precision_math.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalMath {
    // ----------------------------------------------------
    // // /**
    // //  * <h3>Log(2) approximation to 1000 decimal places</h3>
    // //  * I just copied answer from WolframAlpha: {@link https://www.wolframalpha.com/input?i=ln%282%29}
    // //  */
    // // /*public static final BigDecimal Log2 = new BigDecimal(
    // //     "0.6931471805599453094172321214581765680755001343602552541206800094933936219696947156058633269964186875420014810205706857336855202357581305570326707516350759619307275708283714351903070386238916734711233501153644979552391204751726815749320651555247341395258829504530070953263666426541042391578149520437404303855008019441706416715186447128399681717845469570262716310645461502572074024816377733896385506952606683411372738737229289564935470257626520988596932019650585547647033067936544325476327449512504060694381471046899465062201677204245245296126879465461931651746813926725041038025462596568691441928716082938031727143677826548775664850856740776484514644399404614226031930967354025744460703080960850474866385231381816767514386674766478908814371419854942315199735488037516586127535291661000710535582498794147295092931138971559982056543928717000721808576102523688921324497138932037843935308877482597017155910708823683627589842589185353024363421436706118923678919237231467232172053401649256872747782344535347"
    // // );*/
    // // ----------------------------------------------------
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
     * Arctangent approximation using taylor series. You can read more on wikipedia: {@link https://en.wikipedia.org/wiki/Taylor_series#Trigonometric_functions}
     * <p>
     * It's precision is around 1x10^(-50) and time of execution is around 10ms.
     */
    public static BigDecimal arctan(BigDecimal x) {
        // If |x| is greater than one, it will return null
        if (x.abs().compareTo(BigDecimal.ONE) > 0) {
            return null;
        }
        BigDecimal ans = new BigDecimal(0);
        // // long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(50)) <= 0; n = n.add(BigDecimal.ONE)) {
            BigDecimal numerator = MINUSONE.pow(n.intValue());
            BigDecimal denominator = (TWO.multiply(n)).add(BigDecimal.ONE);
            ans = ans.add((numerator.divide(denominator, 1000, RoundingMode.HALF_UP)).multiply(x.pow(((TWO.multiply(n)).add(BigDecimal.ONE)).intValue())));
        }
        // // long endTime = System.nanoTime();
        // //System.out.println((endTime-startTime)/1000000+"ms");
        return ans.setScale(50, RoundingMode.HALF_UP);
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
        // // long startTime = System.nanoTime();
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(new BigDecimal(150)) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add((z.pow(n.intValue())).divide(factorial(n), 50, RoundingMode.HALF_UP));
        }
        // // long endTime = System.nanoTime();
        // // System.out.println((endTime-startTime)/1000000+"ms");
        return ans;
    }
    /**
     * <h3>Natural logarithm function for BigDecimal</h3>
     * I used modified Newton algorithm for computing this. You can read something here on wikipedia: {@link https://en.wikipedia.org/wiki/Natural_logarithm#High_precision}
     * <p>
     * It's precision is around 1x10^(-50) but time of execution is around 300ms, so it is not that fast, but precise.
     */
    public static BigDecimal log(BigDecimal x) {
        long startTime = System.nanoTime();
        BigDecimal n = x; BigDecimal term;
        if (x.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        for (int i = 1; i<=10; i++) {
            BigDecimal eToX = exp(x);
            term = eToX.subtract(n).divide(eToX, 50, RoundingMode.HALF_UP);
            x = x.subtract(term);
        }
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000+"ms");
        return x.setScale(50, RoundingMode.HALF_UP);
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
