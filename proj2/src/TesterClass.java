import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TesterClass extends JPanel implements MouseListener {

	static double sum = 0.0;


	public static int pointCount;

	int scaleX = 500, scaleY = 500;

	static Point point1 = new Point(-100, -100);
	static Point point2 = new Point(-100, -100);

	public TesterClass() {
		setFocusable(true);
		addMouseListener(this);

	}

	public static Tree<Line> tree;

	public static void main(String args[]) {

		String filename = args[0];
		Scanner scan;

		try {
			scan = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println(" ---- file " + filename + " was not found ---- ");
			return;
		}

		tree = new Tree<Line>();

		int n = scan.nextInt();
		for (int i = 0; i < n; i = i + 1) {

			double x = scan.nextDouble();
			double y = scan.nextDouble();
			Point p = new Point(x, y);

			x = scan.nextDouble();
			y = scan.nextDouble();
			Point q = new Point(x, y);

			tree.insert(new Line(p, q));

		}


		double avg = avgPathLength(tree);
		System.out.println("The avg path iss " + avg);

		TesterClass test = new TesterClass();
		JFrame frame = new JFrame("Frame");
		frame.add(test);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		frame.setSize(1000, 1000);

	}


	public void paintComponent(Graphics g) {

		g.setColor(new Color(0, 255, 255));
		g.fillRect(0,0, scaleX, scaleY);


		g.setColor(Color.RED);

		for (Line l:  tree.getList()) {

			System.out.println(l);

			g.drawLine((int) (l.A.x * scaleX),(int) (l.A.y * scaleY), (int) (l.B.x * scaleX), (int) (l.B.y * scaleY));

		}

		//}

	}

	public static double avgPathLength(Tree<Line> root) {

		List list = root.getList();

		double size = (double) list.size();
		double avg = sum / size;

		return avg;

	}

	public static String search(Tree<Line> root, Point p1, Point p2) {

		if (root == null) {
			return "points in the same region ";
		}

		Line l = root.data;
		int RIGHT = Line.RIGHT, LEFT = Line.LEFT;

		if (p1.sideOf(l) == RIGHT) {

			if (p2.sideOf(l) == RIGHT) {

				root = root.rightChild;
				if (root == null) {
					return "points in the same region";
				}
				return search(root, p1, p2);

			}

		} else if (p1.sideOf(l) == LEFT) {

			if (p2.sideOf(l) == LEFT) {

				root = root.leftChild;

				if (root == null) {
					return "points in the same region";
				}
				return search(root, p1, p2);

			}

		}

		return "points are separated with " + l.toString();

	}

	// mouse methods
	@Override
	public void mouseClicked(MouseEvent e) {

		double x = e.getX();
		double y = e.getY();

		pointCount++;
		Graphics g = getGraphics();
		g.setColor(Color.BLACK);
		int r = 10;
		g.fillOval((int)x - r/2, (int)y - r/2, r, r);
		x = x /scaleX;
		y = y / scaleY;
		if (pointCount % 2 == 1) {

			point1.x = x;
			point1.y = y;

		} else {


			point2.x = x;
			point2.y = y;


			System.out.println("The point one has values "+point1.x+" "+point1.y);
			System.out.println("The point two has values "+point2.x+" "+point2.y);

			// tree.printPreOrder();

			search(tree, point1, point2);
			System.out.println();



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
