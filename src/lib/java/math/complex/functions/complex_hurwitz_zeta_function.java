package lib.java.math.complex.functions;
// package lib.java.math.complex.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lib.java.math.complex.BigComplexNumbers;
import lib.java.math.complex.ComplexNumbers;
import lib.java.math.functions.binomial_coefficient;

public class complex_hurwitz_zeta_function {
    private BigDecimal Infinity = new BigDecimal(75);
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
    /*
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
                // For real value of s > 1 and -a is not an natural number
                else if (s.real.compareTo(ONE.real) > 0 && )
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
    }*/
    // Series representaion
    /*
    public BigComplexNumbers _hurwitz_zeta_function(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        ans = (ONE.div(s.sub(ONE))).mul(inf_sum(s, a));
        return ans;
    }   
    // Infinite sum
    private BigComplexNumbers inf_sum(BigComplexNumbers s, BigComplexNumbers a) {
        BigComplexNumbers ans = new BigComplexNumbers();
        for (BigDecimal k = BigDecimal.ZERO; k.compareTo(Infinity) <= 0; k = k.add(BigDecimal.ONE)) {
            BigComplexNumbers K = new BigComplexNumbers(k, BigDecimal.ZERO);
            System.out.println(k);
            ans = ans.add(
                (ONE.div(K.add(ONE))).mul(fin_sum(s, a, k))
            );
        }
        return ans;
    }
    // Finite sum
    private BigComplexNumbers fin_sum(BigComplexNumbers s, BigComplexNumbers a, BigDecimal k) {
        BigComplexNumbers ans = new BigComplexNumbers();
        binomial_coefficient binomial = new binomial_coefficient();
        for (BigDecimal j = BigDecimal.ZERO; j.compareTo(k) <= 0; j = j.add(BigDecimal.ONE)) {
            BigComplexNumbers J = new BigComplexNumbers(j, BigDecimal.ZERO);
            System.out.println("\t"+j);
            ans = ans.add(
                ((MINUS.pow(J)).mul(
                    new BigComplexNumbers(binomial._big_binomial_coefficiont(k.doubleValue(), j.doubleValue()), BigDecimal.ZERO).mul(
                        (a.add(J)).pow(ONE.sub(s))
                    )
                ))
            );
        }
        return ans;
    }
    */
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
        System.out.println("First part done");
        // System.out.println("\t"+firstSum);
        firstSum = firstSum.mul(new BigComplexNumbers(BigDecimal.TEN, BigDecimal.ZERO));
        // System.out.println("\t"+firstSum);
        BigComplexNumbers secondSum = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        for (BigDecimal k = BigDecimal.ONE; k.compareTo(Infinity) < 0; k = k.add(BigDecimal.ONE)) {
            secondSum = secondSum.add(_function(a, s, X(k.divide(Infinity, 50, RoundingMode.HALF_UP))));
            System.out.println("\tDone");
        }
        System.out.println("Second part done");
        // System.out.println("\t"+secondSum);
        BigComplexNumbers thirdSum = _function(a, s, X(new BigDecimal(0.9))).div(TWO);
        System.out.println("Third part done");
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
        BigComplexNumbers E = new BigComplexNumbers(new BigDecimal(Math.E), BigDecimal.ZERO);
        BigComplexNumbers numerator = (s.mul((T.div(a)).atan())).sin();
        BigComplexNumbers denominator = ((a.square().add(T.square())).pow(s.div(TWO))).mul(((TWOPI.mul(T)).exp()).sub(ONE));
        // System.out.println("\t"+(a.square().add(T.square())).pow(s.div(TWO)));
        ans = numerator.div(denominator);
        return ans;
    }
    
}