package lib.java.math.complex.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lib.java.math.complex.BigComplexNumbers;

public class complex_trigamma_function {
    BigDecimal N = new BigDecimal(50);
    BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO);
    BigComplexNumbers ZERO = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
    BigDecimal zero= new BigDecimal(0.001);
    BigDecimal one = new BigDecimal(0.999);
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
    // public 
}
