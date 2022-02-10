package lib.java.math.complex;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import download.BigDecimalMath;

public class BigComplexNumbers {
    public BigDecimal real;
    public BigDecimal img;
    // Empty constructor
    public BigComplexNumbers() {
        real = new BigDecimal(0);
        img = new BigDecimal(0);
    }
    // Complex number constructor
    public BigComplexNumbers(BigDecimal r, BigDecimal i) {
        real = r; img = i;
    }
    // Displaying function
    public void display() {
        String plusMinus = "+";
        if (img.compareTo(BigDecimal.ZERO) < 0) {
            plusMinus = "-";
        }
        System.out.println(
            real.toString()+plusMinus+(img.abs()).toString()+"i"
        );
    }
    // To string function
    public String toString() {
        String plusMinus = "+";
        if (img.compareTo(BigDecimal.ZERO) < 0) {
            plusMinus = "-";
        }
        return real.toString()+plusMinus+(img.abs()).toString()+"i";
    }
    // Addition function
    public BigComplexNumbers add(BigComplexNumbers b) {
        BigComplexNumbers ans = new BigComplexNumbers();
        ans.real = real.add(b.real);
        ans.img = img.add(b.img);
        return ans;
    }
    // Substraction function
    public BigComplexNumbers sub(BigComplexNumbers b) {
        BigComplexNumbers ans = new BigComplexNumbers();
        ans.real = real.subtract(b.real);
        ans.img = img.subtract(b.img);
        return ans;
    }
    // Multiplication function
    public BigComplexNumbers mul(BigComplexNumbers b) {
        BigComplexNumbers ans = new BigComplexNumbers();
        ans.real = real.multiply(b.real).subtract(img.multiply(b.img));
        ans.img = real.multiply(b.img).add(img.multiply(b.real));
        return ans;
    }
    // Division function
    public BigComplexNumbers div(BigComplexNumbers b) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigDecimal real_numerator = real.multiply(b.real).add(img.multiply(b.img));
        BigDecimal img_numerator = img.multiply(b.real).subtract(real.multiply(b.img));
        BigDecimal denominator = b.real.pow(2).add(b.img.pow(2));
        ans.real = real_numerator.divide(denominator, 50, RoundingMode.HALF_UP);
        ans.img = img_numerator.divide(denominator, 50, RoundingMode.HALF_UP);
        return ans;
    }
    // Natural logarithm
    public BigComplexNumbers ln() {
        BigComplexNumbers ans = new BigComplexNumbers();
        Support support = new Support();
        BigDecimal r = (real.pow(2).add(img.pow(2))).sqrt(new MathContext(10));
        BigDecimal sigma = new BigDecimal(0);
        if (img.compareTo(BigDecimal.ZERO) != 0 || real.compareTo(BigDecimal.ZERO) == 0) {
            sigma = (new BigDecimal(2)).multiply(support.atan(img.divide(real.pow(2).add(img.pow(2)).sqrt(new MathContext(10)).add(real), 50, RoundingMode.HALF_UP)));
        } else if (real.compareTo(BigDecimal.ZERO) < 0 && img.compareTo(BigDecimal.ZERO) == 0) {
            sigma = new BigDecimal(Math.PI);
        } else {
            return ans;
        }
        ans.real = support.ln(r);
        ans.img = sigma;
        return ans;
    }
    // Exponentional function
    public BigComplexNumbers exp() {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigDecimalMath math = new BigDecimalMath();
        // ans.real =
        return ans; 
    }
    // Exponentionation
    public BigComplexNumbers pow(BigComplexNumbers b) {
        BigComplexNumbers ans = new BigComplexNumbers();
        Support support = new Support();
        BigDecimal r = (real.pow(2).add(img.pow(2))).sqrt(new MathContext(10));
        BigDecimal sigma = new BigDecimal(0);
        if (img.compareTo(BigDecimal.ZERO) != 0 || real.compareTo(BigDecimal.ZERO) == 0) {
            sigma = (new BigDecimal(2)).multiply(support.atan(img.divide(real.pow(2).add(img.pow(2)).sqrt(new MathContext(10)).add(real), 50, RoundingMode.HALF_UP)));
        } else if (real.compareTo(BigDecimal.ZERO) < 0 && img.compareTo(BigDecimal.ZERO) == 0) {
            sigma = new BigDecimal(Math.PI);
        } else {
            return ans;
        }
        BigComplexNumbers part1 = new BigComplexNumbers();
        BigComplexNumbers part2 = new BigComplexNumbers();
        // part1 = (b.mul(new BigComplexNumbers(support.ln(r), BigDecimal.ZERO)));
        // ans.real = support.exp(new BigDecimal(2));
        return ans;
    }
}
class Support {
    public BigDecimal atan(BigDecimal x) {
        BigDecimal ans = new BigDecimal(0); BigDecimal n = new BigDecimal(1000000);
        BigDecimal mult = x.divide(n, 50, RoundingMode.HALF_UP);
        BigDecimal firstSum = atan_function(BigDecimal.ZERO).divide(new BigDecimal(2), 50, RoundingMode.HALF_UP);
        BigDecimal secondSum = BigDecimal.ZERO;
        for (int k = 1; k <= n.intValue(); k++) {
            BigDecimal K = new BigDecimal(k);
            secondSum = secondSum.add(atan_function(K.multiply(x.divide(n, 50, RoundingMode.HALF_UP))));
        }
        BigDecimal thirdSum = atan_function(x).divide(new BigDecimal(2), 50, RoundingMode.HALF_UP);
        ans = mult.multiply(firstSum.add(secondSum.add(thirdSum)));
        return ans;
    }
    private BigDecimal atan_function(BigDecimal z) {
        return BigDecimal.ONE.divide(z.pow(2).add(BigDecimal.ONE), 50, RoundingMode.HALF_UP);
    }
    public BigDecimal ln(BigDecimal a) {
        BigDecimal ans = new BigDecimal(0); BigDecimal n = new BigDecimal(1000000);
        BigDecimal mult = (a.subtract(BigDecimal.ONE)).divide(n, 50, RoundingMode.HALF_UP);
        BigDecimal firstSum = ln_function(BigDecimal.ONE).divide(new BigDecimal(2), 50, RoundingMode.HALF_UP);
        BigDecimal secondSum = BigDecimal.ZERO;
        for (int k = 1; k <= n.intValue(); k++) {
            BigDecimal K = new BigDecimal(k);
            secondSum = secondSum.add(ln_function(BigDecimal.ONE.add(K.multiply((a.subtract(BigDecimal.ONE)).divide(n, 50, RoundingMode.HALF_UP)))));
        }
        BigDecimal thirdSum = ln_function(a).divide(new BigDecimal(2), 50, RoundingMode.HALF_UP);
        ans = mult.multiply(firstSum.add(secondSum.add(thirdSum)));
        return ans;
    }
    private BigDecimal ln_function(BigDecimal x) {
        return BigDecimal.ONE.divide(x, 50, RoundingMode.HALF_UP);
    }
    // public BigDecimal exp(BigDecimal x) {
    //     BigDecimal ans = new BigDecimal(0); BigDecimal n = new BigDecimal(1000000);
    //     // BigDecimal mult = ()
    //     return ans;
    // }
    private BigDecimal big_factorial(int m) {
        if (m == 0) {
            return new BigDecimal("1");
        } else {
            BigDecimal answer = new BigDecimal(String.valueOf(m));
            for (int i = 1; i < m; i++) {
                answer = answer.multiply(new BigDecimal(String.valueOf(m-1)));
            }
            return answer;
        }
    }
}