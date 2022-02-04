package lib.java.math.complex;

import java.lang.Math;
import lib.java.math.functions.sign_function;

public class ComplexNumbers {
    // Real part & Imaginary part
    public double real; public double img;
    // Empty constructor
    public ComplexNumbers() {
        real = Double.NaN; img = Double.NaN;
    }
    // Complex number constructor
    public ComplexNumbers(double r, double i) {
        real = r; img = i;
    }
    // Displaying function
    public void display() {
        String plusMinus = "+";
        if (img < 0) {
            plusMinus = "";
        }
        System.out.println(String.valueOf(real)+plusMinus+String.valueOf(img)+"i");
    }
    // To string function
    public String toString() {
        String plusMinus = "+";
        if (img < 0) {
            plusMinus = "";
        }
        return String.valueOf(real)+plusMinus+String.valueOf(img)+"i";
    }
    // Addition function
    public ComplexNumbers add(ComplexNumbers b) {
        ComplexNumbers ans = new ComplexNumbers();
        ans.real = real+b.real;
        ans.img = img+b.img;
        return ans;
    }
    // Substraction function
    public ComplexNumbers sub(ComplexNumbers b) {
        ComplexNumbers ans = new ComplexNumbers();
        ans.real = real-b.real;
        ans.img = img-b.img;
        return ans;
    }
    // Multiplication
    public ComplexNumbers mul(ComplexNumbers b) {
        ComplexNumbers ans = new ComplexNumbers();
        ans.real = real*b.real-img*b.img;
        ans.img = real*b.img+b.real*img;
        return ans;
    }
    // Squaring
    public ComplexNumbers square() {
        ComplexNumbers ans = new ComplexNumbers();
        ans.real = Math.pow(real, 2)-Math.pow(img, 2);
        ans.img = 2*real*img;
        return ans;
    }
    // Square root
    public ComplexNumbers root() {
        ComplexNumbers ans = new ComplexNumbers();
        Support support = new Support();
        ans.real = support.gamma(real, img);
        ans.img = support.delta(real, img);
        return ans;
    }
    // Division
    public ComplexNumbers div(ComplexNumbers b) {
        ComplexNumbers ans = new ComplexNumbers();
        double real_numerator = real*b.real+img*b.img;
        double img_numerator = img*b.real-real*b.img;
        double denominator = Math.pow(b.real, 2)+Math.pow(b.img, 2);
        ans.real = real_numerator/denominator;
        ans.img = img_numerator/denominator;
        return ans;
    }
    // Natural Logaritms
    public ComplexNumbers ln(int k) {
        ComplexNumbers ans = new ComplexNumbers();
        double r = Math.sqrt(Math.pow(real, 2)+Math.pow(img, 2));
        double sigma;
        if (img != 0 || real > 0) {
            sigma = 2*Math.atan(img/(Math.sqrt(Math.pow(real, 2)+Math.pow(img, 2))+real));
        } else if (real < 0 && img == 0) {
            sigma = Math.PI;
        } else {
            return ans;
        }
        ans.real = Math.log(r);
        ans.img = (sigma+2*Math.PI*k);
        return ans;
    }
    public ComplexNumbers ln() {
        ComplexNumbers ans = new ComplexNumbers();
        double r = Math.sqrt(Math.pow(real, 2)+Math.pow(img, 2));
        double sigma;
        if (img != 0 || real > 0) {
            sigma = 2*Math.atan(img/(Math.sqrt(Math.pow(real, 2)+Math.pow(img, 2))+real));
        } else if (real < 0 && img == 0) {
            sigma = Math.PI;
        } else {
            return ans;
        }
        ans.real = Math.log(r);
        ans.img = sigma;
        return ans;
    }
    // Exponentionl function
    public ComplexNumbers exp() {
        ComplexNumbers ans = new ComplexNumbers();
        ans.real = Math.pow(Math.E, real)*Math.cos(img);
        ans.img = Math.pow(Math.E, real)*Math.sin(img);
        return ans;
    }
    // Sin function
    public ComplexNumbers sin() {
        ComplexNumbers ans = new ComplexNumbers();
        ans.real = Math.sin(real)*Math.cosh(img);
        ans.img = Math.cos(real)*Math.sinh(img);
        return ans;
    }
    // Cos function
    public ComplexNumbers cos() {
        ComplexNumbers ans = new ComplexNumbers();
        ans.real = Math.cos(real)*Math.cosh(img);
        ans.img = -Math.sin(real)*Math.sinh(img);
        return ans;
    }
    // Exponentiation
    public ComplexNumbers pow(ComplexNumbers b) {
        ComplexNumbers ans = new ComplexNumbers();
        double r = Math.sqrt(Math.pow(real, 2)+Math.pow(img, 2));
        double sigma;
        if (img != 0 || real > 0) {
            sigma = 2*Math.atan(img/(Math.sqrt(Math.pow(real, 2)+Math.pow(img, 2))+real));
        } else if (real < 0 && img == 0) {
            sigma = Math.PI;
        } else {
            return ans;
        }
        ComplexNumbers part1 = new ComplexNumbers();
        ComplexNumbers part2 = new ComplexNumbers();
        part1 = (b.mul(new ComplexNumbers(Math.log(r), 0))).exp();
        part2 = (b.mul(new ComplexNumbers(sigma, 0)).cos()).add(((b.mul(new ComplexNumbers(sigma, 0))).sin()).mul(new ComplexNumbers(0, 1)));
        ans = part1.mul(part2);
        return ans;
    }
}
// Supporting function for Complex numbers
class Support {
    public double gamma(double a, double b) {
        double ans = Math.sqrt((a+Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)))/2);
        return ans;
    }
    public double delta(double a, double b) {
        sign_function sgn = new sign_function();
        double ans = sgn._sign_function(b)*Math.sqrt((-a+Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)))/2);
        return ans;
    }
}
