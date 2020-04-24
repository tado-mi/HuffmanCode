import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LocatorGUI extends JPanel implements MouseListener {

	int s;

	Point p1, p2;
	LineLocator locator;

	public LocatorGUI(String filename) {

		locator = new LineLocator(filename);
		s = 500;

		JFrame frame = new JFrame("Frame");
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		frame.setSize(s, s);

		this.addMouseListener(this);


	}

	public static void main(String args[]) {

		String filename = args[0];
		LocatorGUI test = new LocatorGUI(filename);


	}

	public void paintComponent(Graphics g) {

		g.setColor(new Color(0, 255, 255));
		g.fillRect(0, 0, s, s);

		g.setColor(Color.RED);
		for (Line line: locator.root.getList()) {

			int ax = (int) line.A.x * s,
				ay = (int) line.A.y * s,
				bx = (int) line.B.x * s,
				by = (int) line.B.y * s;

			g.drawLine(ax, ay, bx, by);

		}

	}


		// mouse methods
	@Override
	public void mouseClicked(MouseEvent e) {

		double x = e.getX();
		double y = e.getY();

		// radius to draw the point just clicked
		int r = 10;

		Graphics g = getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval((int)x - r/2, (int)y - r/2, r, r);

		// scale x and y down
		x = x / s;
		y = y / s;

		if (p1 == null) {

			p1 = new Point(x, y);

		} else if (p2 == null) {

			p2 = new Point(x, y);

			System.out.println("Point 1: " + p1 + ";\nPoint 2: " + p2);
			Line line = locator.locate(p1, p2);

			if (line != null) {

				g.setColor(Color.GREEN);

				int ax = (int) line.A.x * s,
					ay = (int) line.A.y * s,
					bx = (int) line.B.x * s,
					by = (int) line.B.y * s;

				g.drawLine(ax, ay, bx, by);

			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stubu

	}


}
