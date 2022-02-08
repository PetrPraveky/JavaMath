package lib.java.math.complex.functions;

import lib.java.math.complex.ComplexNumbers;

public class generalized_stieljes_constant {
    int Infinity = (int)1E2;
    // ComplexNumbers ZERO = new ComplexNumbers(0, 0);
    ComplexNumbers ONE = new ComplexNumbers(1, 0);
    ComplexNumbers TWO = new ComplexNumbers(2, 0);
    ComplexNumbers HALF = new ComplexNumbers(0.5, 0);
    ComplexNumbers I = new ComplexNumbers(0, 1);
    ComplexNumbers firstPartStorage = new ComplexNumbers();
    ComplexNumbers secondFirstPartStorage = new ComplexNumbers(); ComplexNumbers secondSecondPartStorage = new ComplexNumbers();

    ComplexNumbers division1;
    public ComplexNumbers _stieljes_constant(int n, ComplexNumbers a) {
        ComplexNumbers ans = new ComplexNumbers(0, 0);
        ComplexNumbers N = new ComplexNumbers(n, 0);
        ComplexNumbers firstPart = ((ONE.div(TWO.mul(a))).sub((a.ln()).div(N.add(ONE)))).mul((a.ln().pow(new ComplexNumbers(n, 0))));
        // ComplexNumbers secondPart = (I.mul(adaptiveQuad(0, 10, a, n)));
        ComplexNumbers secondPart = (I.mul(Integral(a, N)));
        ans = firstPart.sub(secondPart);
        return ans;
    }
    private ComplexNumbers Integral(ComplexNumbers a, ComplexNumbers n) {
        ComplexNumbers ans = new ComplexNumbers();
        ComplexNumbers firstPart = new ComplexNumbers(1/Infinity, 0);
        ComplexNumbers sumFirst = function(a, n, 0).div(TWO);
        ComplexNumbers sumSecond = new ComplexNumbers(0, 0);
        for (int k = 1; k <= Infinity; k++) {
            sumSecond = sumSecond.add(function(a, n, X(k/Infinity)));
        }
        ComplexNumbers sumThird = function(a, n, X(0.9999)).div(TWO);
        ans = firstPart.mul((sumFirst.add(sumSecond)).add(sumThird));
        return ans;
    }
    private double X(double x) {
        return (x/(1-x));
    }
    private ComplexNumbers function(ComplexNumbers a, ComplexNumbers n, double x) {
        ComplexNumbers ans = new ComplexNumbers(); ComplexNumbers IX = new ComplexNumbers(0, x);
        if (x == 0) {
            x = 1E-6;
        }
        ComplexNumbers firstPart = ONE.div((new ComplexNumbers(Math.pow(Math.E, 2*Math.PI*x), 0)).sub(ONE));
        if (firstPart.real == 0 || Double.isNaN(firstPart.real) || Double.isInfinite(firstPart.real)) {
            firstPart = firstPartStorage;
        } else {
            firstPartStorage = firstPart;
        }
        ComplexNumbers secondFirstPart = (((a.sub(IX)).ln()).pow(n)).div(a.sub(IX));
        if (Double.isNaN(secondFirstPart.real) || secondFirstPart.real == 0 || Double.isInfinite(secondFirstPart.real)) {
            secondFirstPart = secondFirstPartStorage;
        } else {
            secondFirstPartStorage = secondFirstPart;
        }
        ComplexNumbers secondSecondPart = (((a.add(IX)).ln()).pow(n)).div(a.add(IX));
        if (Double.isNaN(secondSecondPart.real) || secondSecondPart.real == 0 || Double.isInfinite(secondSecondPart.real)) {
            secondSecondPart = secondSecondPartStorage;
        } else {
            secondSecondPartStorage = secondSecondPart;
        }
        ans = firstPart.mul(secondFirstPart.sub(secondSecondPart));
        return ans;
    }
    /*
    private ComplexNumbers adaptiveQuad(double a, double b, ComplexNumbers s, int n) {
        double EPSILON = 1E-6;
        double step = b-a;
        double c = (a+b)/2;
        double d = (a+c)/2;
        double e = (b+c)/2;
        ComplexNumbers S1 = (_inside_function(s, n, a).add(_inside_function(s, n, c).mul(new ComplexNumbers(4, 0))).add(
            _inside_function(s, n, b))).mul(new ComplexNumbers(step/6, 0));
        ComplexNumbers S2 = (_inside_function(s, n, a).add(_inside_function(s, n, d).mul(new ComplexNumbers(4, 0))).add(
            _inside_function(s, n, c).mul(new ComplexNumbers(2, 0))).add(_inside_function(s, n, e).mul(new ComplexNumbers(4, 0))).add(
            _inside_function(s, n, b))).mul(new ComplexNumbers(step/12, 0));
        ComplexNumbers ans = (S2.sub(S1)).div(new ComplexNumbers(15, 0));
        if (S2.sub(S1).mod() <= EPSILON) {
            return S2.add(ans);
        } else {
            return adaptiveQuad(a, c, s, n).add(adaptiveQuad(c, b, s, n));
        }
    }
    private ComplexNumbers _inside_function(ComplexNumbers a, int n, double t) {
        ComplexNumbers ans = new ComplexNumbers();
        ComplexNumbers IX = new ComplexNumbers(0, t);
        ans = (
            ((ONE).div(new ComplexNumbers(Math.pow(Math.E, 2*Math.PI*t), 0)).sub(ONE)).mul(
                ((((a.sub(IX)).ln()).pow(new ComplexNumbers(n, 0))).div(a.sub(IX))).sub(
                    (((a.add(IX)).ln()).pow(new ComplexNumbers(n, 0))).div(a.add(IX))
                )
            )
        );
        return ans;
    }
    */
}
