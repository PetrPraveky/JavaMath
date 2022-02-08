package lib.java.math.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class binomial_coefficient {
    public double _binomial_coefficient(double n, double k) {
        if (k > n) {
            return Double.NaN;
        } else if (k == n) {
            return 1;
        } else if (k == 0) {
            return 1;
        } else {
            System.out.println((factorial((int)k)*(factorial((int)(n-k)))));
            double ans = factorial((int)n)/(factorial((int)k)*(factorial((int)(n-k))));
            return ans;
        }
    }
    // Basic factorial function
    private int factorial(int m) {
        if (m == 0) {
            return 1;
        } else {
            int answer = m;
            for (int i = 1; i < m; i++) {
                answer *= m-i;
            }
            return answer;
        }
    }
    public BigDecimal _big_binomial_coefficiont(double n, double k) {
        if (k > n) {
            return new BigDecimal("NaN");
        } else if (k == n) {
            return new BigDecimal("1");
        } else if (k == 0) {
            return new BigDecimal("1");
        } else {
            // double ans = factorial((int)n)/(factorial((int)k)*(factorial((int)(n-k))));
            // return ans;
            BigDecimal ans = big_factorial((int)n).divide(big_factorial((int)k).multiply(big_factorial((int)(n-k))), 10, RoundingMode.HALF_UP);
            return ans;
        }
    }
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
