package lib.java.math.plotter.function_plotter.fourier_series;

import java.awt.*;  
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.lang.Math;
import lib.java.math.functions.fourier_series.sawtooth_wave;

public class sawtooth_wave_plotter extends JPanel {
    ArrayList<ArrayList<Double>> coords;
    ArrayList<ArrayList<Double>> inverse_coords;
    int min = -5; int max = 5;
    int margin = 30;
    // double mul = 15; // Mul for 150 points
    double mul = 60; // Mul for 600 points
    double amountOfParts = 1/mul;
    // Drawing function
    protected void paintComponent(Graphics grf) {
        // Create instance of Graphics
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D)grf;
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth(); int height = getHeight();
        graph.setFont(new Font("Arial", Font.PLAIN, 15));
        // Draw points
        // -- multipliers
        // double multiplier = 120*mul; // Multiplier for 150 points
        double multiplier = mul; // Multiplier for 600 points
        double xSize = (double)(width-2*margin)/(coords.size()-1);
        for (int i = 0; i<coords.size()-1; i++) {
            // Set color of points
            graph.setPaint(Color.BLUE);
            double x1 = width/2+(xSize*multiplier*coords.get(i).get(0));
            double y1 = height/2+(xSize*multiplier*coords.get(i).get(1));
            double x2 = width/2+(xSize*multiplier*coords.get(i+1).get(0));
            double y2 = height/2+(xSize*multiplier*coords.get(i+1).get(1));
            graph.draw(new Line2D.Double(x1, y1, x2, y2));
            // Set color of points
            graph.setPaint(Color.RED);
            double ix1 = width/2+(xSize*multiplier*inverse_coords.get(i).get(0));
            double iy1 = height/2+(xSize*multiplier*inverse_coords.get(i).get(1));
            double ix2 = width/2+(xSize*multiplier*inverse_coords.get(i+1).get(0));
            double iy2 = height/2+(xSize*multiplier*inverse_coords.get(i+1).get(1));
            graph.draw(new Line2D.Double(ix1, iy1, ix2, iy2));
        }
        // Set color of axis
        graph.setPaint(Color.BLACK);
        // Draw graph
        graph.draw(new Line2D.Double(width/2, margin-20, width/2, height-margin+20));
        graph.draw(new Line2D.Double(margin-20, height/2, width-margin+20, height/2));
        // Draw values on graph
        graph.drawString("Plottend numbers from: "+String.valueOf(min)+" to "+String.valueOf(max), margin+20, height-margin-6); // Right corner legend
        graph.drawString("Sawtooth wave", margin, margin); // Right corner legend
        graph.drawString("(blue - normal with a = 4, p = pi\n", margin, margin+20); // Right corner legend
        graph.drawString("(red - normal with a = 2, p = pi/2\n", margin, margin+40); // Right corner legend
    }
    // Constructor
    public sawtooth_wave_plotter() {
        sawtooth_wave wave = new sawtooth_wave();
        coords = new ArrayList<ArrayList<Double>>();
        inverse_coords = new ArrayList<ArrayList<Double>>();
        for (double i = min; i<= max; i += amountOfParts) {
            ArrayList<Double> coord = new ArrayList<Double>();
            ArrayList<Double> inverse_coord = new ArrayList<Double>();
            coord.add((double)i); inverse_coord.add((double)i);
            coord.add(wave._sawtooth_wave(i, 4, (Math.PI)));
            inverse_coord.add(wave._reverse_sawtooth_wave(i, 2, (Math.PI/2)));
            coords.add(coord); inverse_coords.add(inverse_coord);
        }
    }
}
