package lib.java.math.functions;

public class mobius_function {
    // Mobius function
    public int _mobius_function(int n) {
        kronecker_delta delta = new kronecker_delta();
        prime_omega_function omega = new prime_omega_function();
        liouville_function lioville = new liouville_function();
        int answer = delta._kronecker_delta(omega.prime_low_omega_function(n), omega.prime_up_omega_function(n))*lioville._liouville_function(n);
        return answer;
    }
}
