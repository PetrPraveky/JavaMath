package lib.java.math.complex;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
        real = real.setScale(50, RoundingMode.CEILING);
        img = img.setScale(50, RoundingMode.CEILING);
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
        if (img.compareTo(BigDecimal.ZERO) == 0 && real.compareTo(BigDecimal.ZERO) > 0) {
            ans.real = support.ln(real); ans.img = BigDecimal.ZERO;
            return ans;
        } else {
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
    }
    // Exponentional function
    public BigComplexNumbers exp() {
        BigComplexNumbers ans = new BigComplexNumbers();
        Support support = new Support();
        ans.real = support.exp(real).multiply(support.cos(img));
        ans.img = support.exp(real).multiply(support.sin(img));
        return ans; 
    }
    // Sin function
    public BigComplexNumbers sin() {
        BigComplexNumbers ans = new BigComplexNumbers();
        Support support = new Support();
        ans.real = support.sin(real).multiply(support.cosh(img));
        ans.img = support.cos(real).multiply(support.sinh(img));
        return ans;
    }   
    // Cos function
    public BigComplexNumbers cos() {
        BigComplexNumbers ans = new BigComplexNumbers();
        Support support = new Support();
        ans.real = support.cos(real).multiply(support.cosh(img));
        ans.img = (new BigDecimal(-1)).multiply(support.sin(real).multiply(support.sinh(img)));
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
        } else if (real.compareTo(BigDecimal.ZERO) > 0 && img.compareTo(BigDecimal.ZERO) == 0) {
            sigma = BigDecimal.ZERO;
        } else if (real.compareTo(BigDecimal.ZERO) == 0 && img.compareTo(BigDecimal.ZERO) == 0) {
            return ans;
        }
        BigComplexNumbers part1 = new BigComplexNumbers();
        BigComplexNumbers part2 = new BigComplexNumbers();
        part1 = (b.mul(new BigComplexNumbers(support.ln(r), BigDecimal.ZERO))).exp();
        part2 = (b.mul(new BigComplexNumbers(sigma, BigDecimal.ZERO)).cos()).add(((b.mul(new BigComplexNumbers(sigma, BigDecimal.ZERO))).sin()).mul(new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ONE)));
        ans = part1.mul(part2);
        return ans;
    }
}
class Support {
    // Integral for arc tangent approximation
    public BigDecimal atan(BigDecimal x) {
        BigDecimal ans = new BigDecimal(0); BigDecimal n = new BigDecimal(100);
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
    // Inside function for arc tanget integral approximation
    private BigDecimal atan_function(BigDecimal z) {
        return BigDecimal.ONE.divide(z.pow(2).add(BigDecimal.ONE), 50, RoundingMode.HALF_UP);
    }
    // Integral for natural logarithm approximaion
    public BigDecimal ln(BigDecimal a) {
        BigDecimal ans = new BigDecimal(0); BigDecimal n = new BigDecimal(100);
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
    // Inside ufnction of integral for natural logarithm approximation
    private BigDecimal ln_function(BigDecimal x) {
        return BigDecimal.ONE.divide(x, 50, RoundingMode.HALF_UP);
    }
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
    // Sin function using Taylor series
    public BigDecimal sin(BigDecimal x) {
        BigDecimal ans = new BigDecimal(0); BigDecimal Infinity = new BigDecimal(100);
        // Taylor approximation
        for (BigDecimal n = new BigDecimal(0); n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add(
                ((new BigDecimal(Math.pow(-1, n.intValue()))).divide(big_factorial(2*n.intValue()+1), 50, RoundingMode.HALF_UP)).multiply(x.pow(2*n.intValue()+1))
            );
        }
        return ans;
    }
    // Cos function using Taylor series
    public BigDecimal cos(BigDecimal x) {
        BigDecimal ans = new BigDecimal(0); BigDecimal Infinity = new BigDecimal(100);
        // Taylor approximation
        for (BigDecimal n = new BigDecimal(0); n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add(
                ((new BigDecimal(Math.pow(-1, n.intValue()))).divide(big_factorial(2*n.intValue()), 50, RoundingMode.HALF_UP)).multiply(x.pow(2*n.intValue()))
            );
        }
        return ans;
    }
    // Sinh function using Taylor series
    public BigDecimal sinh(BigDecimal x) {
        BigDecimal ans = new BigDecimal(0); BigDecimal Infinity = new BigDecimal(100);
        // Taylor approximation
        for (BigDecimal n = new BigDecimal(0); n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add(
                ((x.pow(2*n.intValue()+1)).divide(big_factorial(2*n.intValue()+1), 50, RoundingMode.HALF_UP))
            );
        }
        return ans;
    }
    // Cosh function using Taylor series
    public BigDecimal cosh(BigDecimal x) {
        BigDecimal ans = new BigDecimal(0); BigDecimal Infinity = new BigDecimal(100);
        // Taylor approximation
        for (BigDecimal n = new BigDecimal(0); n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add(
                ((x.pow(2*n.intValue())).divide(big_factorial(2*n.intValue()), 50, RoundingMode.HALF_UP))
            );
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
    }
}