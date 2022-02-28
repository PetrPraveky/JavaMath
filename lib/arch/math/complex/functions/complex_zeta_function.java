package lib.java.math.complex.functions;

import lib.java.math.complex.ComplexNumbers;
import java.lang.Math;

public class complex_zeta_function {
    // Euler-Riemann zeta function (for all Complex numbers)
    public ComplexNumbers _riemann_zeta_function(ComplexNumbers s) {
        ComplexNumbers ans = new ComplexNumbers();
        ComplexNumbers one = new ComplexNumbers(1, 0);
        ComplexNumbers two = new ComplexNumbers(2, 0);
        ComplexNumbers C1 = (two.pow(s.sub(one))).div(s.sub(one));
        ComplexNumbers C2 = two.pow(s);
        ComplexNumbers mult = C2.mul(adaptiveQuad(0, 10, s));
        if (s.real < 0 && s.real % 2 == 0 && s.img == 0) {
            ans.real = 0; ans.img = 0;
            return ans;
        } else {
            ans = C1.sub(mult);
            return ans;
        }
    }
    private ComplexNumbers adaptiveQuad(double a, double b, ComplexNumbers s) {
        double EPSILON = 1E-6;
        double step = b-a;
        double c = (a+b)/2;
        double d = (a+c)/2;
        double e = (b+c)/2;
        ComplexNumbers S1 = (_inside_function(s, a).add(_inside_function(s, c).mul(new ComplexNumbers(4, 0))).add(
            _inside_function(s, b))).mul(new ComplexNumbers(step/6, 0));
        ComplexNumbers S2 = (_inside_function(s, a).add(_inside_function(s, d).mul(new ComplexNumbers(4, 0))).add(
            _inside_function(s, c).mul(new ComplexNumbers(2, 0))).add(_inside_function(s, e).mul(new ComplexNumbers(4, 0))).add(
            _inside_function(s, b))).mul(new ComplexNumbers(step/12, 0));
        ComplexNumbers ans = (S2.sub(S1)).div(new ComplexNumbers(15, 0));
        if (S2.sub(S1).mod() <= EPSILON) {
            return S2.add(ans);
        } else {
            return adaptiveQuad(a, c, s).add(adaptiveQuad(c, b, s));
        }
    }
    private ComplexNumbers _inside_function(ComplexNumbers s, double t) {
        ComplexNumbers ans = new ComplexNumbers();
        ans = ((s.mul((new ComplexNumbers(t, 0)).atan())).sin()).div(
            ((new ComplexNumbers((1+Math.pow(t, 2)), 0)).pow(s.div(new ComplexNumbers(2, 0)))).mul(
                new ComplexNumbers((Math.pow(Math.E, (Math.PI*t))), 0)
            ));
        return ans;
    }
}
