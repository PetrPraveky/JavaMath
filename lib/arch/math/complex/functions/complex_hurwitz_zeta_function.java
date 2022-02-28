package lib.java.math.complex.functions;
// package lib.java.math.complex.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lib.java.math.complex.BigComplexNumbers;

public class complex_hurwitz_zeta_function {
    private BigDecimal Infinity = new BigDecimal(75);
    private BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO); private BigComplexNumbers TWO = new BigComplexNumbers(new BigDecimal(2), BigDecimal.ZERO);
    // Integral represenation
    public BigComplexNumbers _hurwitz_zeta_function(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers firstPart = (a.pow(ONE.sub(s))).div(s.sub(ONE)); // First part of integral represenantion
        BigComplexNumbers secondPart = _integral(s, a);
        BigComplexNumbers thirdPart = (ONE.div(TWO.mul(a.pow(s))));
        ans = firstPart.add(TWO.mul(secondPart)).add(thirdPart);
        // System.out.println(thirdPart);
        return ans;
    }
    // Integral
    public BigComplexNumbers _integral(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers mul = ONE.div(new BigComplexNumbers(Infinity, BigDecimal.ZERO));
        BigComplexNumbers firstSum = _function(a, s, new BigDecimal(0.001)).div(TWO);
        // System.out.println("First part done");
        // System.out.println("\t"+firstSum);
        firstSum = firstSum.mul(new BigComplexNumbers(BigDecimal.TEN, BigDecimal.ZERO));
        // System.out.println("\t"+firstSum);
        BigComplexNumbers secondSum = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        for (BigDecimal k = BigDecimal.ONE; k.compareTo(Infinity) < 0; k = k.add(BigDecimal.ONE)) {
            secondSum = secondSum.add(_function(a, s, X(k.divide(Infinity, 50, RoundingMode.HALF_UP))));
            // System.out.println("\tDone");
        }
        // System.out.println("Second part done");
        // System.out.println("\t"+secondSum);
        BigComplexNumbers thirdSum = _function(a, s, X(new BigDecimal(0.9))).div(TWO);
        // System.out.println("Third part done");
        // System.out.println("\t"+thirdSum);
        ans = mul.mul(firstSum.add(secondSum.add(thirdSum)));
        return ans;
    }
    // X
    public BigDecimal X(BigDecimal x) {
        // System.out.println(x);
        // System.out.println(x.divide(BigDecimal.ONE.subtract(x), 50, RoundingMode.HALF_UP));
        return (x.divide(BigDecimal.ONE.subtract(x), 50, RoundingMode.HALF_UP));
    }
    // Inner function
    public BigComplexNumbers _function(BigComplexNumbers a, BigComplexNumbers s, BigDecimal x) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers T = new BigComplexNumbers(x, BigDecimal.ZERO);
        BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO); BigComplexNumbers TWO = new BigComplexNumbers(new BigDecimal(2), BigDecimal.ZERO);
        BigComplexNumbers TWOPI = new BigComplexNumbers(new BigDecimal(Math.PI*2), BigDecimal.ZERO);
        BigComplexNumbers numerator = (s.mul((T.div(a)).atan())).sin();
        BigComplexNumbers denominator = ((a.square().add(T.square())).pow(s.div(TWO))).mul(((TWOPI.mul(T)).exp()).sub(ONE));
        // System.out.println("\t"+(a.square().add(T.square())).pow(s.div(TWO)));
        ans = numerator.div(denominator);
        return ans;
    }
    
}