package lib.java.math.plotter.function_plotter;

import java.awt.*;  
import javax.swing.*;  
import java.awt.geom.*;
import java.util.ArrayList;

import lib.java.math.functions.mobius_function;

public class mobius_plotter extends JPanel {
    ArrayList<ArrayList<Integer>> coords;
    int margin = 30; int n = 50;
    // Drawing function
    protected void paintComponent(Graphics grf) {
        // Create instance of Graphics
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D)grf;
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth(); int height = getHeight();
        graph.setFont(new Font("Arial", Font.PLAIN, 15));
        // Draw graph
        graph.draw(new Line2D.Double(margin, margin-20, margin, height-margin+20));
        graph.draw(new Line2D.Double(margin, height/2, width-margin+20, height/2));
        // Find x values
        double x = (double)(width-2*margin)/(coords.size()-1);
        double scale = (double)((height-2*margin)/getMax())*10;
        // Draw values on graph
        graph.drawString("0", margin/2, height/2+6); // 0 on Y-axis
        graph.drawString("1", margin/2, (int)(height/2-scale*1+6)); // 1 on Y-axis
        graph.drawString("-1", margin/2, (int)(height/2-scale*(-1)+6)); // -1 on Y-axis
        graph.drawString("Plottend numbers from: 1 to "+String.valueOf(n), margin+20, height-margin-6); // Right corner legend
        graph.drawString("Möbius function", margin+20, margin); // Right corner legend
        // Set color of points
        graph.setPaint(Color.BLUE);
        // Draw points
        for (int i = 0; i < coords.size(); i++) {
            double x1 = margin+coords.get(i).get(0)*x;
            double y1 = height/2-scale*coords.get(i).get(1);
            graph.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));
        }
    }
    private int getMax() {
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < coords.size(); i++) {
            for (int j = 0; j < coords.get(i).size(); j++) {
                if(coords.get(i).get(j) > max) {
                    max = coords.get(i).get(j);
                }
            }
        }
        return max;
    }
    // Constructor
    public mobius_plotter() {
        mobius_function mobius = new mobius_function();
        int mul = 1;
        coords = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> coord = new ArrayList<>();
            coord.add(i*mul); coord.add(mobius._mobius_function(i)*mul);
            coords.add(coord);
        }
    }
}