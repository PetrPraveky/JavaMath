package lib.java.math.complex.functions;

import java.math.BigDecimal;

import lib.java.math.complex.BigComplexNumbers;

public class complex_trigamma_function {
    private BigDecimal Infinity = new BigDecimal(10000);
    private BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO);
    // Sum of series
    public BigComplexNumbers _trigamma_function(BigComplexNumbers z) {
        BigComplexNumbers ans = new BigComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        for (BigDecimal n = BigDecimal.ZERO; n.compareTo(Infinity) <= 0; n = n.add(BigDecimal.ONE)) {
            ans = ans.add(ONE.div((z.add(new BigComplexNumbers(n, BigDecimal.ZERO))).square()));
        }
        return ans;
    }
}
