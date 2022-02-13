package lib.java.math.complex.functions;

import java.math.BigDecimal;

import lib.java.math.complex.BigComplexNumbers;

public class complex_digamma_function {
    public BigComplexNumbers _digamma_function(BigComplexNumbers x) {
        BigComplexNumbers ans = new BigComplexNumbers();
        BigComplexNumbers ONE = new BigComplexNumbers(BigDecimal.ONE, BigDecimal.ZERO); BigComplexNumbers TWO = new BigComplexNumbers(new BigDecimal(2), BigDecimal.ZERO);
        ans = (x.ln()).sub(ONE.div(TWO.mul(x)));
        return ans;
    }
}
