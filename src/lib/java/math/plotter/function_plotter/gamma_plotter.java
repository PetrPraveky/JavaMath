package lib.java.math.plotter.function_plotter;

import java.awt.*;  
import javax.swing.*;  
import java.awt.geom.*;
import java.util.ArrayList;
import lib.java.math.functions.gamma_function;

public class gamma_plotter extends JPanel {
    ArrayList<ArrayList<Double>> coords;
    int margin = 30;
    int min = -5;
    int max = 5;
    double mul = 1000000; 
    double amountOfParts = 1/mul;
    // Drawing function
    protected void paintComponent(Graphics grf) {
        // Create instance of Graphics
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D)grf;
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth(); int height = getHeight();
        graph.setFont(new Font("Arial", Font.PLAIN, 15));
        // Draw graph
        graph.draw(new Line2D.Double(width/2, margin-20, width/2, height-margin+20));
        graph.draw(new Line2D.Double(margin-20, height/2, width-margin+20, height/2));
        // Find x values
        double x = (double)(width-2*margin)/(coords.size()-1);
        // Draw values on graph
        graph.drawString("Plottend numbers from: "+String.valueOf(min)+" to "+String.valueOf(max), margin+20, height-margin-6); // Right corner legend
        graph.drawString("Gamma function", margin+20, margin); // Right corner legend
        // Set color of points
        graph.setPaint(Color.BLUE);
        // Draw points
        for (int i = 0; i < coords.size()-1; i++) {
            double x1 = width/2+coords.get(i).get(0)*x;
            double y1 = height/2-coords.get(i).get(1)*(amountOfParts*(10));
            double x2 = width/2+coords.get(i+1).get(0)*x;
            double y2 = height/2-coords.get(i+1).get(1)*(amountOfParts*(10));
            if (y1 < 0 && y2 > 0 || y2 < 0 && y1 > 0) {

            } else {
                graph.draw(new Line2D.Double(x1, y1, x2, y2));
            }
        }
    }
    // Constructor
    public gamma_plotter() {
        gamma_function gamma = new gamma_function();
        coords = new ArrayList<ArrayList<Double>>();
        for (double i = min; i <= max; i += amountOfParts) {
            ArrayList<Double> coord = new ArrayList<>();
            if (gamma._gamma_function(i) == Double.POSITIVE_INFINITY) {             
            } else {
                coord.add(i*mul); 
                coord.add(gamma._gamma_function(i)*mul);
                coords.add(coord);
            }
        }
    }
}
