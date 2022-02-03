package lib.java.math.functions;

import java.lang.Math;

public class gamma_function {
    private static final double sqrt2Pi = Math.sqrt(2*Math.PI);
    // Gamma function
    public double _gamma_function(double z) {
        if (Math.floor(z) == z && z > 0) {
            if (z == 1) {
                return 1;
            } else {
                return (double)factorial((int)(z-1));
            }
        } else if (Math.floor(z) == z && z <= 0) {
            return Double.POSITIVE_INFINITY;
        }  else if (z > 0) {
            return Math.exp(logGamma(z));
        } else if (z < 0) {
            return (1/z)*(_gamma_function(z+1));
        } else {
            return Double.NaN;
        }
    }
    // Log gamma function
    private double logGamma(double x) {
        double temp = (x - 0.5)*Math.log(x + 4.5) - (x + 4.5);
        double ser = 1.0+76.18009173/(x+0)-86.50532033/(x+1)+24.01409822/(x+2)-1.231739516/(x+3)+0.00120858003/(x+4)-0.00000536382/(x+5);
        return temp + Math.log(ser*sqrt2Pi);
    }
    // Basic factorial function
    private int factorial(int m) {
        int answer = m;
        for (int i = 1; i < m; i++) {
            answer *= m-i;
        }
        return answer;
    }
}
