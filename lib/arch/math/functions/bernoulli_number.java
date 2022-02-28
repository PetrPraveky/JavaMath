package lib.java.math.functions;

import java.lang.Math;

public class bernoulli_number {
    public double _bernoulli_number(int k) {
        riemann_zeta_function zeta = new riemann_zeta_function();
        double answer = 0;
        double numerator = (Math.pow((-1), k+1)*2*factorial(2*k));
        double denominator = Math.pow((2*Math.PI), 2*k);
        double mul = zeta._riemann_zeta_function(2*k);
        answer = (numerator/denominator)*mul;
        return answer;
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
