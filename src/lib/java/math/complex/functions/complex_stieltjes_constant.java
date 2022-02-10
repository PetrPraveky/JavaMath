package lib.java.math.complex.functions;

import java.math.BigDecimal;
import lib.java.math.complex.BigComplexNumbers;
// import lib.java.math.complex.ComplexNumbers;
import java.math.RoundingMode;

public class complex_stieltjes_constant {
    BigDecimal Infinity = new BigDecimal(100);
    // Complex numbers for basic integers
    BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO);
    BigComplexNumbers TWO = new BigComplexNumbers(new BigDecimal(2), BigDecimal.ZERO);
    BigComplexNumbers HALF = new BigComplexNumbers(new BigDecimal(0.5), BigDecimal.ZERO);
    BigComplexNumbers I = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ONE);
    // Generalized stieltjes constant
    public BigComplexNumbers _stieltjes_constant(int n, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers N = new BigComplexNumbers(new BigDecimal(n), BigDecimal.ZERO);
        // First part
        BigComplexNumbers firstPart = (
            ((ONE.div(TWO.mul(a))).sub((a.ln()).div(N.add(ONE)))).mul((a.ln()).pow(N))    
        );
        // Second part
        BigComplexNumbers secondPart = (I.mul(Integral(a, N)));
        ans = firstPart.sub(secondPart);
        return ans;
    }
    // Integral part of stieltjes constant generalization
    private BigComplexNumbers Integral(BigComplexNumbers a, BigComplexNumbers n) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers firstPart = new BigComplexNumbers(ONE.real.divide(Infinity, 50, RoundingMode.HALF_UP), BigDecimal.ZERO);
        BigComplexNumbers sumFirst = function(a, n, BigDecimal.ZERO).div(TWO);
        System.out.println("first sum done");
        BigComplexNumbers sumSecond = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        for (BigDecimal k = new BigDecimal(0); k.compareTo(Infinity) <= 0; k = k.add(BigDecimal.ONE)) {
            if (k.compareTo(Infinity) == 0) {
                sumSecond = sumSecond.add(function(a, n, X(new BigDecimal(0.9999))));
            } else {
                sumSecond = sumSecond.add(function(a, n, X(k.divide(Infinity, 50, RoundingMode.HALF_UP))));
            }
            System.out.println("\tPart done");
        }
        System.out.println("second sum done");
        BigComplexNumbers sumThird = function(a, n, X(new BigDecimal(0.9999))).div(TWO);
        System.out.println("third sum done");
        ans = firstPart.mul(sumFirst.add(sumSecond).add(sumThird));
        return ans;
    }
    // X value
    private BigDecimal X(BigDecimal x) {
        return (x.divide(BigDecimal.ONE.subtract(x), 50, RoundingMode.HALF_UP));
    }
    // Inner function of Integral
    private BigComplexNumbers function(BigComplexNumbers a, BigComplexNumbers n, BigDecimal x) {
        BigComplexNumbers ans = new BigComplexNumbers(); BigComplexNumbers IX = new BigComplexNumbers(BigDecimal.ZERO, x);
        Support support = new Support();
        if (x.compareTo(BigDecimal.ZERO) == 0) {
            x = new BigDecimal(1E-6);
        }
        BigComplexNumbers firstPart = ONE.div(
            (new BigComplexNumbers(support.exp(new BigDecimal(String.valueOf(2*Math.PI)).multiply(x)), BigDecimal.ZERO)).sub(ONE)
        );
        BigComplexNumbers secondFirstPart = (((a.sub(IX)).ln()).pow(n)).div(a.sub(IX));
        BigComplexNumbers secondSecondPart = (((a.add(IX)).ln()).pow(n)).div(a.add(IX));
        ans = firstPart.mul(secondFirstPart.sub(secondSecondPart));
        return ans;
    }
}
class Support {
    // Exponential function using Taylor series
    public BigDecimal exp(BigDecimal x) {
        BigDecimal ans = new BigDecimal(0); BigDecimal Infinity = new BigDecimal(100);
        if (x.compareTo(BigDecimal.ZERO) < 0) {
            ans = BigDecimal.ONE.divide(exp(x.abs()), 50, RoundingMode.HALF_UP);
            return ans;
        } else if (x.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        } else {
            // Taylor approximation
            for (BigDecimal n = new BigDecimal(0); n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
                ans = ans.add((x.pow(n.intValue())).divide(big_factorial(n.intValue()), 50, RoundingMode.HALF_UP));
            }
            return ans;
        }
    }
    private BigDecimal big_factorial(int m) {
        if (m == 0) {
            return new BigDecimal("1");
        } else {
            BigDecimal answer = new BigDecimal(String.valueOf(m));
            for (int i = 1; i < m; i++) {
                answer = answer.multiply(new BigDecimal(String.valueOf(m-i)));
            }
            return answer;
        }
    }
}