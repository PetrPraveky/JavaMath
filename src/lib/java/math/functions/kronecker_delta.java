package lib.java.math.functions;

public class kronecker_delta {
    // Kronecker delta function
    public int _kronecker_delta(int i, int j) {
        if (i == j) {
            return 1;
        } else {
            return 0;
        }
    }
}
