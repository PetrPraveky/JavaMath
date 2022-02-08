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

        // for (int k = 0; k<=Infinity; k++) {
        //     ComplexNumbers K = new ComplexNumbers(k, 0);
        //     ComplexNumbers firtsPart = (((K.add(a)).ln()).pow(N)).div(K.add(a));
        //     ComplexNumbers secondPart = (((M.add(a)).ln()).pow(N.add(new ComplexNumbers(1, 0)))).div(N.add(new ComplexNumbers(1, 0)));
        //     ans = ans.add((firtsPart).sub(secondPart));
        // }
        ComplexNumbers firstPart = ((ONE.div(TWO.mul(a))).sub((a.ln()).div(N.add(ONE))));
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
        System.out.println(firstPart+"1");
        System.out.println(sumFirst+"2");
        System.out.println(sumSecond+"3");
        System.out.println(sumThird+"4");
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
        // System.out.println((new ComplexNumbers(Math.pow(Math.E, (2*Math.PI*x)), 0)));
        // System.out.println(x);
        // System.out.println("\t"+Math.exp(Math.PI*2*x));
        if (firstPart.real == 0 || Double.isNaN(firstPart.real) || Double.isInfinite(firstPart.real)) {
            firstPart = firstPartStorage;
        } else {
            firstPartStorage = firstPart;
        }
        System.out.println("\t"+firstPart);
        ComplexNumbers secondFirstPart = (((a.sub(IX)).ln()).pow(n)).div(a.sub(IX));
        if (Double.isNaN(secondFirstPart.real) || secondFirstPart.real == 0 || Double.isInfinite(secondFirstPart.real)) {
            secondFirstPart = secondFirstPartStorage;
        } else {
            secondFirstPartStorage = secondFirstPart;
        }
        System.out.println("\t\t"+secondFirstPart);
        ComplexNumbers secondSecondPart = (((a.add(IX)).ln()).pow(n)).div(a.add(IX));
        if (Double.isNaN(secondSecondPart.real) || secondSecondPart.real == 0 || Double.isInfinite(secondSecondPart.real)) {
            secondSecondPart = secondSecondPartStorage;
        } else {
            secondSecondPartStorage = secondSecondPart;
        }
        System.out.println("\t\t\t"+secondSecondPart);
        ans = firstPart.mul(secondFirstPart.sub(secondSecondPart));
        // System.out.println("\t"+firstPart);
        // System.out.println("\t"+secondFirstPart);
        // System.out.println("\t"+secondSecondPart);
        System.out.println("\t\t+"+secondFirstPart.sub(secondSecondPart));
        System.out.println(ans+"+++");
        return ans;
    }
    // private ComplexNumbers _first_stieljes_constant(int n, ComplexNumbers a) {

    // }
}
