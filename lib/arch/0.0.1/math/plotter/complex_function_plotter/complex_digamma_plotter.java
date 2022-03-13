package lib.java.math.plotter.complex_function_plotter;

import java.awt.*;  
import javax.swing.*;
import java.awt.geom.*;
import java.math.BigDecimal;
import java.util.ArrayList;

import lib.java.math.complex.BigComplexNumbers;
import lib.java.math.complex.functions.complex_digamma_function;
import lib.java.math.complex.DomainColoring;

public class complex_digamma_plotter extends JPanel {
    ArrayList<ArrayList<Double>> coords;
    int margin = 30;
    int min = -3;
    int max = 3;
    //// double mul = 15;  // Mul for 22k points
    //// double mul = 30; // Mul for 90k points
    double mul = 60; // Mul for 130k points
    double amountOfParts = 1/mul;
    // HSB values
    ArrayList<Double> H;
    // Sorted coords
    ArrayList<Double> sortedReal;
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
        System.out.println(coords.size());
        double xSize = (double)(width-2*margin)/(coords.size()-1);
        //// double multiplier = 120*mul; // Multiplier for 22k points
        //// double multiplier = 480*(mul); // Multiplier for 130k points
        double multiplier = 280*mul; // Multiplier for 130k points
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
        graph.drawString("Digamma function", margin+20, margin+12); // Right corner legend
    }
    public complex_digamma_plotter() {
        complex_digamma_function gamma = new complex_digamma_function();
        coords = new ArrayList<ArrayList<Double>>();
        // X Coord
        for (double i = min; i <= max; i += amountOfParts) {
            for (double j = min; j <= max; j += amountOfParts) {
                ArrayList<Double> coord = new ArrayList<>();
                // System.out.println(i);
                // System.out.println("\t"+j);
                if (Math.floor(i) == i && i <= 0 && j == 0 || i == 0) {
                } else {
                    coord.add(i); // Real part
                    coord.add(j); // Imaginary part
                    // ComplexNumbers result = gamma._gamma_function(new ComplexNumbers(i, j));
                    BigComplexNumbers result = gamma._digamma_function(new BigComplexNumbers(new BigDecimal(i), new BigDecimal(j)));
                    coord.add(result.real.doubleValue()); // Real result
                    coord.add(result.img.doubleValue()); // Imaginary result
                    coords.add(coord);
                }
            }
        }
    }
}
