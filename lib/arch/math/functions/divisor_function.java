package lib.java.math.functions;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class divisor_function {
    List<Integer> prime_factor_base;
    List<Integer> prime_factor;
    List<Integer> factor_power;
    public double _divisor_function(double x, double n) {
        prime_omega_function omega = new prime_omega_function();
        prime_factor_base = omega.prime_factor((int)n); prime();
        double ans = 1;
        if (x == 0) {
            for (int i = 0; i < omega.prime_low_omega_function((int)n); i++) {
                ans *= (a(i)+1);
            }
        } else {
            for (int i = 0; i < omega.prime_low_omega_function((int)n); i++) {
                double numerator = Math.pow(p(i), ((a(i)+1)*x))-1;
                double determinator = Math.pow(p(i), x)-1;
                ans *= numerator/determinator;
            }
        }
        return ans;
    }
    private double p(int i) {
        return (double)prime_factor.get(i);
    }
    private double a(int i) {
        return (double)factor_power.get(i);
    }
    private void prime() {
        prime_factor = new ArrayList<Integer>();
        factor_power = new ArrayList<Integer>();
        for (int i = 0; i<prime_factor_base.size(); i++) {
            if (prime_factor.contains(prime_factor_base.get(i))) {
                int index = prime_factor.indexOf(prime_factor_base.get(i));
                factor_power.set(index, factor_power.get(index)+1);
            } else {
                prime_factor.add(prime_factor_base.get(i));
                factor_power.add(1);
            }

        }
    }
}
