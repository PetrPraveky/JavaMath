package lib.java.math.complex.functions.fourier_series;

import lib.java.math.complex.ComplexNumbers;
import lib.java.math.functions.divisor_function;
import lib.java.math.functions.riemann_zeta_function;
import lib.java.math.complex.functions.complex_zeta_function;
import java.lang.Math;

public class eisenstein_series {
    int sum_max = 10;
    ComplexNumbers q;
    public ComplexNumbers G(int k, ComplexNumbers t) {
        ComplexNumbers ans = new ComplexNumbers();
        q = ((new ComplexNumbers(Math.PI, 0)).mul(new ComplexNumbers(0, 1)).mul(t)).exp();
        riemann_zeta_function zeta = new riemann_zeta_function();
        ComplexNumbers one = new ComplexNumbers(1, 0);
        ComplexNumbers part1 = new ComplexNumbers((2*zeta._riemann_zeta_function(2*k)), 0);
        ComplexNumbers part2 = one.add(c(k).mul(sum(k)));
        ans = part1.mul(part2);
        return ans;
    }    
    private ComplexNumbers sum(int k) {
        ComplexNumbers sum = new ComplexNumbers(0, 0);
        divisor_function sigma = new divisor_function();
        for (int n = 1; n <=sum_max; n++) {
            ComplexNumbers add = ((new ComplexNumbers(sigma._divisor_function(2*k-1, n), 0)).mul(q.pow(new ComplexNumbers(n, 0))));
            sum = sum.add(add);
        }
        return sum;
    }
    private ComplexNumbers c(int k) {
        complex_zeta_function zeta = new complex_zeta_function();
        ComplexNumbers one = new ComplexNumbers(1, 0); ComplexNumbers two = new ComplexNumbers(2, 0);
        ComplexNumbers c = two.div(zeta._riemann_zeta_function(one.sub(new ComplexNumbers(2*k, 0))));
        return c;
    }
}
