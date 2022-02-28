package lib.java.math.functions;

import java.lang.Math;

public class riemann_zeta_function {
    // Euler-Riemann zeta function (for real numbers larger than 1)
    public double _riemann_zeta_function(double s) {
        mobius_function mobius = new mobius_function();
        double answer = 0; int nMax = 10000;
        if (s == 1) {
            return Double.POSITIVE_INFINITY;
        }
        else if (s > 1) {
            for (int i = 1; i<=nMax; i++) {
                answer += (mobius._mobius_function(i))/(Math.pow(i, s));
            }
            return Math.pow(answer, -1);
        }
        else {
            return Double.NaN;
        }
    }
}
