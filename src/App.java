// import lib.java.math.functions.kronecker_delta;
// import lib.java.math.functions.liouville_function;
import lib.java.math.functions.prime_omega_function;

public class App {
    public static void main(String[] args) throws Exception {
        prime_omega_function omega = new prime_omega_function();
        System.out.println(omega.prime_up_omega_function(48));
        System.out.println(omega.prime_low_omega_function(48));
    }
}
