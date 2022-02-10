package lib.java.math.complex.functions;

import java.math.BigDecimal;
import lib.java.math.complex.BigComplexNumbers;

public class complex_hurwitz_zeta_function {
    BigDecimal Infinity = new BigDecimal(10);
    BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO);
    BigComplexNumbers MINUS = new BigComplexNumbers(new BigDecimal(-1), BigDecimal.ZERO);
    // Hurwitz zeta function done with Laurent series
    /*
    public BigComplexNumbers _hurwitz_zeta_function(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers firstPart = ONE.div(s.sub(ONE));
        BigComplexNumbers secondPart = laurent_series(s, a);
        ans = firstPart.add(secondPart);
        return ans;
    }
    // Infinite sum
    private BigComplexNumbers laurent_series(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        complex_stieltjes_constant stieltjes = new complex_stieltjes_constant();
        for (BigDecimal n = new BigDecimal(0); n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            BigComplexNumbers N = new BigComplexNumbers(n, BigDecimal.ZERO);
            ans = ans.add(
                (MINUS.pow(N).div(new BigComplexNumbers(big_factorial(n.intValue()), BigDecimal.ZERO))).mul(
                    stieltjes._stieltjes_constant(n.intValue(), a).mul((s.sub(ONE)).pow(N))
                )
            );
            System.out.println("\tPart done");
        }
        return ans;
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
    }*/
    // Hurwitz zeta function done using contour integral
}