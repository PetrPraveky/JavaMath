package lib.java.math.functions.fourier_series;

import java.lang.Math;

public class sawtooth_wave {
    // Sawtooth wave
    public double _sawtooth_wave(double t, double a, double p) {
        double ans = 0;
        ans = -((2*a)/Math.PI)*Math.atan(1/(Math.tan((Math.PI*t)/p)));
        return ans;
    }
    public double _reverse_sawtooth_wave(double t, double a, double p) {
        double ans = 0;
        ans = -((2*a)/Math.PI)*Math.atan(1/(Math.tan((Math.PI*t)/p)));
        return ans;
    }
}
