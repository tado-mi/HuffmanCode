import java.util.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;

import javax.swing.*;



public class GUI {
	static int x;
	static int y;


	public static void main(String args[]) {
		// myBST<Line> myTree = new myBST<Line>();
		JFrame f = new JFrame("Draw a Red Line");
	    f.setSize(300, 300);
	    f.setLocation(300, 300);
	    f.setResizable(false);
	    JPanel p = new JPanel() {
	        Point pointStart = null;
	        Point pointEnd   = null;
	        {
	            addMouseListener(new MouseAdapter() {
	                public void mousePressed(MouseEvent e) {
	                    pointStart = e.getPoint();
	                }
	                public void mouseClicked(MouseEvent e) {

	                	x = e.getX();
	                	y = e.getY();

	                	repaint();
	                }

	                public void mouseReleased(MouseEvent e) {
	                    pointStart = null;
	                }
	            });
	            addMouseMotionListener(new MouseMotionAdapter() {
	                public void mouseMoved(MouseEvent e) {
	                    pointEnd = e.getPoint();
	                }

	                public void mouseDragged(MouseEvent e) {
	                    pointEnd = e.getPoint();
	                    repaint();
	                }
	            });
	        }
	        public void paint(Graphics g) {

	            super.paint(g);
	            if (pointStart != null) {
	                g.setColor(Color.RED);
	                g.drawOval(x, y, 5, 5);
	            }
	        }
	    };
	    f.add(p);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
