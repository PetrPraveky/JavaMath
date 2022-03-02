public class IntegrationTest {
    public IntegrationTest() {
        /*
            Let Integral from 0 to infinity from x^2;
        */
        int n = (int)1E7; double sum = 0;
        int a = 0; double b = 0.999999999;
        for (int k = 1; k <= n-1; k++) {
            sum += function(nonInfinityItegration(k/n));
        }
        double ans = (0.99/n)*(function(nonInfinityItegration(a))/2+sum+function(nonInfinityItegration(b))/2);
        System.out.println(ans);
    }
    private double nonInfinityItegration (double x) {
        return (x/(1-x));
    }
    private double function(double x) {
        return Math.pow(Math.E, -x);
    }
}