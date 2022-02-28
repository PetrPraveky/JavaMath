package lib.java.math.plotter.complex_function_plotter;

import java.awt.*;  
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;

import lib.java.math.complex.ComplexNumbers;
import lib.java.math.complex.functions.complex_gamma_function;
import lib.java.math.complex.DomainColoring;

public class complex_gamma_plotter extends JPanel {
    ArrayList<ArrayList<Double>> coords;
    int margin = 30;
    int min = -5;
    int max = 5;
    // double mul = 15;  // Mul for 22k points
    double mul = 30; // Mul for 90k points
    // double mul = 60; // Mul for 360k points
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
        double xSize = (double)(width-2*margin)/(coords.size()-1);
        // double multiplier = 120*mul; // Multiplier for 22k points
        double multiplier = 240*mul; // Multiplier for 90k points
        // double multiplier = 480*mul; // Multiplier for 360k points
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
        graph.drawString("Gamma function", margin+20, margin+12); // Right corner legend
    }
    public complex_gamma_plotter() {
        complex_gamma_function gamma = new complex_gamma_function();
        coords = new ArrayList<ArrayList<Double>>();
        // X Coord
        for (double i = min; i <= max; i += amountOfParts) {
            for (double j = min; j <= max; j += amountOfParts) {
                ArrayList<Double> coord = new ArrayList<>();
                if (Math.floor(i) == i && i <= 0 && j == 0) {
                } else {
                    coord.add(i); // Real part
                    coord.add(j); // Imaginary part
                    ComplexNumbers result = gamma._gamma_function(new ComplexNumbers(i, j));
                    coord.add(result.real); // Real result
                    coord.add(result.img); // Imaginary result
                    coords.add(coord);
                }
            }
        }
    }
}
