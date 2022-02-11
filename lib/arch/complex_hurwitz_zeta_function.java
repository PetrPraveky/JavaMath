// package lib.java.math.complex.functions;

import java.math.BigDecimal;
import lib.java.math.complex.BigComplexNumbers;
import lib.java.math.complex.ComplexNumbers;

public class complex_hurwitz_zeta_function {
    private BigDecimal Infinity = new BigDecimal(10);
    private BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO); private BigComplexNumbers TWO = new BigComplexNumbers(new BigDecimal(2), BigDecimal.ZERO);
    private BigComplexNumbers MINUS = new BigComplexNumbers(new BigDecimal(-1), BigDecimal.ZERO);
    private BigComplexNumbers ZERO = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
    private BigComplexNumbers PI = new BigComplexNumbers(new BigDecimal(Math.PI), BigDecimal.ZERO); private BigComplexNumbers TWOPI = new BigComplexNumbers(new BigDecimal(Math.PI*2), BigDecimal.ZERO);
    private BigComplexNumbers I = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ONE);
    // Hurwitz zeta function done with Laurent series
     /*
    public BigComplexNumbers _hurwitz_zeta_function(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers firstPart = ONE.div(s.sub(ONE));
        // System.out.println(firstPart);
        BigComplexNumbers secondPart = laurent_series(s, a);
        // System.out.println(secondPart);
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
    // Complete hurwitz zeta function
    public BigComplexNumbers _hurwirz_zeta_function(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        if (s.real.compareTo(ONE.real) > 0 && a.real.compareTo(ZERO.real) > 0) {
            // Integral formula
            return ans;
        } else {
            // a is real
            if (a.img.compareTo(ZERO.img) == 0) {
                // If a = 1, then it is reduced to riemann zeta function
                if (a.real.compareTo(ONE.real) == 0) {
                    ComplexNumbers answer = new ComplexNumbers();
                    complex_zeta_function zeta = new complex_zeta_function();
                    answer = zeta._riemann_zeta_function(new ComplexNumbers(s.real.doubleValue(), s.img.doubleValue()));
                    ans.real = new BigDecimal(answer.real);
                    ans.img = new BigDecimal(answer.img);
                    return ans;
                }
                // For real value of s < 0 and 0 < a <= 1
                else if (s.real.compareTo(ZERO.real) < 0 && a.real.compareTo(ONE.real) <= 0 && a.real.compareTo(ZERO.real) > 0) {
                    complex_gamma_function gamma = new complex_gamma_function();
                    ComplexNumbers gamma_ans = gamma._gamma_function(new ComplexNumbers(s.real.doubleValue(), s.img.doubleValue()));
                    BigComplexNumbers partOne = (new BigComplexNumbers(new BigDecimal(gamma_ans.real), new BigDecimal(gamma_ans.img))).div(TWOPI.pow(s));
                    BigComplexNumbers partTwoOne = (
                        (((MINUS.mul(I.mul(s.mul(PI)))).div(TWO)).exp()).mul(a_first_sum(s, a))
                    );
                    BigComplexNumbers partTwoTwo = (
                        (((I.mul(s.mul(PI))).div(TWO)).exp()).mul(a_second_sum(s, a))
                    );
                    ans = partOne.mul(partTwoOne.add(partTwoTwo));
                    return ans;
                }
            }
            return ans;
        }
    }
    // First sum for calculation with s < 0 and 0 < a <= 1
    private BigComplexNumbers a_first_sum(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        for (BigDecimal n = BigDecimal.ONE; n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            BigComplexNumbers N = new BigComplexNumbers(n, BigDecimal.ZERO);
            ans = ans.add(
                ((TWOPI.mul(I.mul(N.mul(a)))).exp()).div(N.pow(s))
            );
        }
        return ans;
    }
    // Second sum for calculation with s < 0 and 0 < a <= 1
    private BigComplexNumbers a_second_sum(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        for (BigDecimal n = BigDecimal.ONE; n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            BigComplexNumbers N = new BigComplexNumbers(n, BigDecimal.ZERO);
            ans = ans.add(
                ((MINUS.mul(TWOPI.mul(I.mul(N.mul(a))))).exp()).div(N.pow(s))
            );
        }
        return ans;
    }
}