package lib.java.math.complex.functions;

import lib.java.math.complex.ComplexNumbers;

public class complex_beta_function {
    public ComplexNumbers _complex_beta_function(ComplexNumbers x, ComplexNumbers y) {
        ComplexNumbers ans = new ComplexNumbers();
        complex_gamma_function gamma = new complex_gamma_function();
        ans = (gamma._gamma_function(x).mul(gamma._gamma_function(y))).div(gamma._gamma_function(x.add(y)));
        return ans;
    }
}
