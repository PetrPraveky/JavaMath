package lib.java.math.plotter.complex_function_plotter;

import java.awt.*;  
import javax.swing.*;

import lib.java.math.complex.functions.complex_hurwitz_zeta_function;
import lib.java.math.complex.BigComplexNumbers;
import lib.java.math.complex.DomainColoring;

import java.awt.geom.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class complex_hurwitz_plotter extends JPanel {
    ArrayList<ArrayList<Double>> coords;
    int margin = 30;
    int min = -5;
    int max = 5;
    // double mul = 3;
    // double mul = 7; // Mul for 5.5k points
    // double mul = 15;  // Mul for 22k points
    // double mul = 30; // Mul for 90k points
    double mul = 60; // Mul for 360k points
    double amountOfParts = 1/mul;
    // HSB values
    ArrayList<Double> H;
    // Domain color values
    ArrayList<Double> HUE;
    ArrayList<Double> LIG;
    // Sorted coords
    ArrayList<Double> sortedReal;
    ArrayList<Double> sortedImg;
    // Drawing function
    protected void paintComponent(Graphics grf) {
        DomainColoring color = new DomainColoring();
        // Create instance of Graphics
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D)grf;
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth(); int height = getHeight();
        graph.setFont(new Font("Arial", Font.PLAIN, 15));
        // Find x values
        double xSize = (double)(width-2*margin)/(coords.size()-1);
        // double multiplier = 30*mul;
        // double multiplier = 60*mul; // Multiplier for 5.5k points
        // double multiplier = 120*mul; // Multiplier for 22k points
        // double multiplier = 240*mul; // Multiplier for 90k points
        double multiplier = 480*mul; // Multiplier for 360k points
        for (int i = 0; i < coords.size(); i++) {
            graph.setPaint(color.HSL(coords.get(i).get(2), coords.get(i).get(3)));
            double x = width/2+(xSize*multiplier*coords.get(i).get(0));
            double y = height/2+(xSize*multiplier*coords.get(i).get(1));
            graph.fill(new Rectangle.Double(x-2, y-2, 2, 2));
        }
        graph.setPaint(Color.BLACK);
        // Draw graph
        graph.draw(new Line2D.Double(width/2, margin-20, width/2, height-margin+20));
        graph.draw(new Line2D.Double(margin-20, height/2, width-margin+20, height/2));
        // Draw values on graph
        graph.drawString("Plottend numbers from: "+String.valueOf(min)+" to "+String.valueOf(max), margin+20, height-margin-6); // Right corner legend
        graph.drawString("Riemann zeta function", margin+20, margin+12); // Right corner legend
    }
    public complex_hurwitz_plotter() {
        complex_hurwitz_zeta_function zeta = new complex_hurwitz_zeta_function();
        coords = new ArrayList<ArrayList<Double>>();
        // X Coord
        for (double i = min; i <= max; i += amountOfParts) {
            for (double j = min; j <= max; j += amountOfParts) {
                ArrayList<Double> coord = new ArrayList<>();
                // System.out.println(i);
                // System.out.println("\t"+j);
                coord.add(i); // Real part
                coord.add(j); // Imaginary part
                BigComplexNumbers s = new BigComplexNumbers(new BigDecimal(i), new BigDecimal(j));
                BigComplexNumbers a = new BigComplexNumbers(new BigDecimal(0.96), BigDecimal.ZERO);
                BigComplexNumbers result = zeta._hurwitz_zeta_function(s, a);
                coord.add(result.real.doubleValue()); // Real result
                coord.add(result.img.doubleValue()); // Imaginary result
                coords.add(coord);
            }
        }
    }
}
