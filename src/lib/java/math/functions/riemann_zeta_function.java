package lib.java.math.functions;

import java.lang.Math;

public class riemann_zeta_function {
    // Euler-Riemann zeta function (for real numbers larger than 1)
    public double _riemann_zeta_function(double s) {
        mobius_function mobius = new mobius_function();
        double answer = 0; int nMax = 1000000;
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
            // for (int i = 1; i<=nMax; i++) {
            //     answer += (1/Math.pow(i, s));
            // }
            // System.out.println(answer);
            // double sum_answer = 0;
            // for (int j = 1; j <=nMax; j++) {
            //     sum_answer += (1/Math.pow(j, (1-s)));
            // }
            // answer += small_gamma(1-s)*sum_answer;
            // return answer;
            return Double.NaN;
        }
    }
    // private double small_gamma(double s) {
    //     gamma_function gamma = new gamma_function();
    //     double answer = Math.pow(Math.PI, (0.5-s))*(gamma._gamma_function(s/2)/gamma._gamma_function(0.5*(1-s)));
    //     return answer;
    // }
}
