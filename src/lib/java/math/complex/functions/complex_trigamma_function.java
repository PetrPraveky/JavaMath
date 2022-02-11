package lib.java.math.complex.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lib.java.math.complex.BigComplexNumbers;

public class complex_trigamma_function {
    /*private BigDecimal N = new BigDecimal(10);*/ private BigDecimal Infinity = new BigDecimal(10000);
    private BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO);
    private BigComplexNumbers ZERO = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
    private BigComplexNumbers MINUS = new BigComplexNumbers(new BigDecimal(-1), new BigDecimal(-1));
    private BigDecimal zero= new BigDecimal(0.001);
    private BigDecimal one = new BigDecimal(0.999);
    // Double integral
    /*
    public BigComplexNumbers _trigamma_function(BigComplexNumbers z) {
        BigComplexNumbers ans = new BigComplexNumbers();
        ans = _trigamma_first_integral(z);
        return ans;
    }
    private BigComplexNumbers _trigamma_first_integral(BigComplexNumbers z) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers mult = ONE.div(new BigComplexNumbers(N, BigDecimal.ZERO));
        BigComplexNumbers firstPart = _trigamma_second_integral(z, zero);
        BigComplexNumbers secondPart = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        for (BigDecimal k = new BigDecimal(1); k.compareTo(N.subtract(BigDecimal.ONE)) <= 0; k = k.add(BigDecimal.ONE)) {
            secondPart = secondPart.add(_trigamma_second_integral(z, k.multiply(BigDecimal.ONE.divide(N, 50, RoundingMode.HALF_UP))));
        }
        BigComplexNumbers thirdPart = _trigamma_second_integral(z, one);
        ans = mult.mul(firstPart.add(secondPart.add(thirdPart)));
        System.out.println("");
        return ans;
    }
    private BigComplexNumbers _trigamma_second_integral(BigComplexNumbers z, BigDecimal x) {
        BigComplexNumbers ans = new BigComplexNumbers();
        if (x.compareTo(BigDecimal.ZERO) == 0) {
            ans.real = BigDecimal.ZERO;
            ans.img = BigDecimal.ZERO;
            return ans;
        } else {
            BigComplexNumbers X = new BigComplexNumbers(x, BigDecimal.ZERO);
            BigComplexNumbers mult = (X.sub(ZERO)).div(new BigComplexNumbers(N, BigDecimal.ZERO));
            BigComplexNumbers firstPart = function(z, x, zero);
            BigComplexNumbers secondPart = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
            for (BigDecimal k = new BigDecimal(1); k.compareTo(N.subtract(BigDecimal.ONE)) <= 0; k = k.add(BigDecimal.ONE)) {
                secondPart = secondPart.add(function(z, x, (k.multiply((x).divide(N, 50, RoundingMode.HALF_UP)))));
            }
            BigComplexNumbers thirdPart = function(z, x, one);
            ans = mult.mul(firstPart.add(secondPart).add(thirdPart));
            return ans;
        }
    }
    private BigComplexNumbers function(BigComplexNumbers z, BigDecimal x, BigDecimal y) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers X = new BigComplexNumbers(x, BigDecimal.ZERO); BigComplexNumbers Y = new BigComplexNumbers(y, BigDecimal.ZERO);   
        X.display();
        ans = ((X).pow(z.sub(ONE))).div(Y.mul(ONE.sub(X)));
        return ans;
    }*/
    // Geometric series
    /*
    public BigComplexNumbers _trigamma_function(BigComplexNumbers z) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers N = new BigComplexNumbers(Infinity, BigDecimal.ZERO);
        BigComplexNumbers partOne = ONE.div(N);
        BigComplexNumbers partTwoOne = (function(z, BigDecimal.ZERO));
        BigComplexNumbers partTwoTwo = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        for (BigDecimal k = BigDecimal.ONE; k.compareTo(Infinity.subtract(BigDecimal.ONE)) <= 0; k = k.add(BigDecimal.ONE)) {
            partTwoTwo = partTwoTwo.add(function(z, (k.divide(Infinity, 50, RoundingMode.HALF_UP))));
        }
        BigComplexNumbers partTwoThree = (function(z, new BigDecimal(0.9999)));
        ans = partOne.mul((partTwoOne.add(partTwoTwo)).add(partTwoThree));
        ans = MINUS.mul(ans);
        return ans;
    }
    private BigComplexNumbers function(BigComplexNumbers z, BigDecimal x) {
        BigComplexNumbers ans = new BigComplexNumbers();
        if (x.compareTo(BigDecimal.ZERO) == 0) {
            ans.real = BigDecimal.ZERO; ans.img = BigDecimal.ZERO;
            return ans;
        } else {
            BigComplexNumbers X = new BigComplexNumbers(x, BigDecimal.ZERO);
            ans = ((X.pow(z.sub(ONE))).mul(X.ln())).div(ONE.sub(X));
            return ans;
        }
    }*/
    // Sum of series
    public BigComplexNumbers _trigamma_function(BigComplexNumbers z) {
        BigComplexNumbers ans = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        System.out.println(z);
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add(ONE.div((z.add(new BigComplexNumbers(n, BigDecimal.ZERO))).square()));
        }
        return ans;
    }
}
