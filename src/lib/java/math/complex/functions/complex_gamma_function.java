package lib.java.math.complex.functions;

import java.lang.Math;
import lib.java.math.complex.ComplexNumbers;

public class complex_gamma_function {
    private static final double sqrt2Pi = Math.sqrt(2*Math.PI);
    // Complex gamma function
    public ComplexNumbers _gamma_function(ComplexNumbers z) {
        ComplexNumbers ans = new ComplexNumbers();
        if (z.img == 0) {
            ans.img = 0;
            if (Math.floor(z.real) == z.real && z.real > 0) {
                if (z.real == 1) {
                    ans.real = 1;
                    return ans;
                }  else {
                    ans.real = (double)factorial((int)(z.real-1));
                }
            } else if (Math.floor(z.real) == z.real && z.real <= 0) {
                ans.real = Double.POSITIVE_INFINITY;
                return ans;
            } else if (z.real > 0) {
                ans.real = Math.exp(logGamma(z.real));
                return ans;
            } else if (z.real < 0) {
                ComplexNumbers gammaOutput = _gamma_function(new ComplexNumbers(z.real+1, 0));
                ans.real = (1/z.real)*(gammaOutput.real);
                return ans;
            }
        } else {
            ans = logGamma(z).exp();
            return ans;
        }
        return ans;
    }
    // Complex log function
    private ComplexNumbers logGamma(ComplexNumbers z) {
        ComplexNumbers temp = (
            ((z.sub(new ComplexNumbers(0.5, 0))).mul((z.add(new ComplexNumbers(4.5, 0))).ln())).sub((z.add(new ComplexNumbers(4.5, 0))))
            );
        ComplexNumbers ser = (
            (new ComplexNumbers(1, 0)).add((new ComplexNumbers(76.18009173, 0)).div(z)).sub(
                (new ComplexNumbers(86.50532033, 0)).div(z.add(new ComplexNumbers(1, 0)))
            ).add(
                (new ComplexNumbers(24.01409822, 0)).div(z.add(new ComplexNumbers(2, 0)))
            ).sub(
                (new ComplexNumbers(1.231739516, 0)).div(z.add(new ComplexNumbers(3, 0)))
            ).add(
                (new ComplexNumbers(0.00120858003, 0)).div(z.add(new ComplexNumbers(4, 0)))
            ).sub(
                (new ComplexNumbers(0.00000536382, 0)).div(z.add(new ComplexNumbers(5, 0)))
            )
        );
        ComplexNumbers ans = temp.add((ser.mul(new ComplexNumbers(sqrt2Pi, 0))).ln());
        return ans;
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
