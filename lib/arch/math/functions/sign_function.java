package lib.java.math.functions;

public class sign_function {
    public int _sign_function(double x) {
        if (x < 0) {
            return -1;
        } else if (x == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
