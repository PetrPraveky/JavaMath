package lib.java.math.complex;

public class ComplexNumbers {
    // Real part & Imaginary part
    double real; double img;
    // Constructor
    public ComplexNumbers(double r, double i) {
        real = r; img = i;
    }
    public void display() {
        String plusMinus = "+";
        if (img < 0) {
            plusMinus = "";
        }
        System.out.println(String.valueOf(real)+plusMinus+String.valueOf(img)+"i");
    }
}
