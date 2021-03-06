package lib.java.math.complex.functions;

import lib.java.math.complex.ComplexNumbers;

public class hurwitz_zeta_function {
    int Infinity = (int)1E3;
    ComplexNumbers TWO = new ComplexNumbers(2, 0); ComplexNumbers ONE = new ComplexNumbers(1, 0);
    ComplexNumbers MINUSONE = new ComplexNumbers(-1, 0);
    ComplexNumbers PI = new ComplexNumbers(Math.PI, 0);

    ComplexNumbers ANS_STORE = new ComplexNumbers();
    // hurwitz zeta function
    public ComplexNumbers _hurwitz_zeta_function(ComplexNumbers s, ComplexNumbers a) {
        complex_gamma_function gamma = new complex_gamma_function();
        ComplexNumbers ans = new ComplexNumbers();
        // Complex real numbers
        if (a.real%2 == 0 && a.real<=0) {
            return ans;
        } else {
            if(s.real < 0) {
                ComplexNumbers partOne = (TWO.mul(gamma._gamma_function(ONE.sub(s)))).div((PI.mul(TWO)).pow(ONE.sub(s)));
                ComplexNumbers partTwo = ((PI.mul(s)).div(TWO)).sin();
                ComplexNumbers sumOne = _sum_one(s, a, Infinity);
                ComplexNumbers partThree = ((PI.mul(s)).div(TWO)).cos();
                ComplexNumbers sumTwo = _sum_two(s, a, Infinity);
                ans = partOne.mul((partTwo.mul(sumOne)).add(partThree.mul(sumTwo)));
                return ans;
            } else {
                return ans;
            }
        }
    }
    // First sum in Hurwitz's formula
    private ComplexNumbers _sum_one(ComplexNumbers s, ComplexNumbers a, int infinity) {
        ComplexNumbers ans = new ComplexNumbers(0, 0);
        for (int n = 1; n<=infinity; n++) {
            ComplexNumbers N = new ComplexNumbers(n, 0);
            ComplexNumbers sum = (((TWO.mul(PI.mul(N.mul(a))))).cos()).div(N.pow(ONE.sub(s)));
            ans = ans.add(sum);
        }
        return ans;
    }
    // Second sum in Hurwitz's formula
    private ComplexNumbers _sum_two(ComplexNumbers s, ComplexNumbers a, int infinity) {
        ComplexNumbers ans = new ComplexNumbers(0, 0);
        for (int n = 1; n<=infinity; n++) {
            ComplexNumbers N = new ComplexNumbers(n, 0);
            ComplexNumbers sum = (((TWO.mul(PI.mul(N.mul(a))))).sin()).div(N.pow(ONE.sub(s)));
            ans = ans.add(sum);
        }
        return ans;
    }
    /*
    public ComplexNumbers _hurwitz_zeta_function(ComplexNumbers s, double a) {
        ComplexNumbers ans = new ComplexNumbers();
        complex_gamma_function gamma = new complex_gamma_function();
        ComplexNumbers firstPart = ONE.sub(gamma._gamma_function(s));

        return ans;
    }
    // Integral for integra representation
    public ComplexNumbers integral() {
        return new ComplexNumbers();
    }
    */
}
