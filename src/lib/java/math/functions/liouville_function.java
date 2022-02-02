package lib.java.math.functions;

import java.lang.Math;

public class liouville_function {
    prime_omega_function omega = new prime_omega_function();
    // Liouville function
    public int _liouville_function(int n) {
        return (int)(Math.pow(-1, omega.prime_up_omega_function(n)));
    }
}
