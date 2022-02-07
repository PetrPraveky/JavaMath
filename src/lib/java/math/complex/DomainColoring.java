package lib.java.math.complex;

import java.awt.Color;

public class DomainColoring {
    double approx_inf = 1E3;
    public Color HSL(double r, double i) {
        double angle;
        if (i != 0 || r > 0) {
            angle = 2*(i/(Math.sqrt(Math.pow(r, 2)+Math.pow(i, 2))+r));
        } else if (r < 0 && i == 0)  {
            angle = Math.PI;
        } else {
            angle = Double.NaN;
        }
        if (angle > 2*Math.PI) {
            angle -= 2*Math.PI;
        }
        double H = (angle+(2*Math.PI)/2)/(2*Math.PI);
        // double radius = Math.sqrt(Math.pow(r, 2)+Math.pow(i, 2));
        // double B = radius*approx_inf;
        // double B = ((2/Math.PI)*Math.atan(radius));
        // int rgb = Color.HSBtoRGB((float)H, 1f, (float)B);
        int rgb = Color.HSBtoRGB((float)H, 1f, 1f);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        return new Color(red, green, blue);
    }
}
