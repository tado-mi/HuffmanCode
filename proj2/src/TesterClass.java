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
	static ArrayList<Integer> x1; 
	static ArrayList<Integer> y1; 
	static ArrayList<Integer> x2; 
	static ArrayList<Integer> y2; 
	static ArrayList<Integer> list; 
	static int x111; 
	static myBST<Line> tree1 = new myBST<>(); 
	static ArrayList<Line> LineList = new ArrayList<>();
	
	public static int pointCount;
	
	static int scaleX = 500, scaleY = 500;

	
	static Point point1 = new Point(-100, -100);
	static Point point2 = new Point(-100, -100);

	public TesterClass() {
		setFocusable(true);
		addMouseListener(this);

	}


	public static void main(String args[]) throws FileNotFoundException {

		TesterClass test = new TesterClass();
		File file = new File(args[0]); 
		// getting values from the console
		Scanner scan = new Scanner(file);
		 x111 = (scan.nextInt());     
             for(int i=0;i<x111;i++) {           	
            	 double x=scan.nextDouble();           	 
                 double y = (scan.nextDouble());
                 Point p = new Point(x, y);
                 x = (scan.nextDouble());
                 y = (scan.nextDouble());
                 Point q = new Point(x, y);
                 Line l = new Line(p, q);
                 LineList.add(l);
                 tree1.insert(l);
                 
             }
             
             
             double avg = avgPathLength(tree1);
    		System.out.println("The avg path iss " + avg);
    		
    		
         	JFrame frame = new JFrame("Frame");
    		frame.add(test);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    		frame.setVisible(true);
    		frame.setSize(1000, 1000);
            	 
             }
	
		



	public static void printNode(MyTreeNode<Line> node) {
		MyTreeNode<Line> n1 = node;
		Line l = node.data;
		System.out.println("The line separating the two points have end points :" + l.p1 + " and " + l.p2);
	}

	public static void preOrdertraversal(MyTreeNode<Line> parent, int count) {

		if (parent != null) {
			// System.out.println(parent.data);

			if (parent.leftChild == null && parent.rightChild == null) {
				// reached the leaf
				list.add(count);

				sum = sum + count;
			}

			count += 1;
			preOrdertraversal(parent.leftChild, count);

			preOrdertraversal(parent.rightChild, count);

		}

	}


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
			
	             tree1.printPreOrder();

	            search(tree1.root, point1, point2);
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
	public void paintComponent(Graphics g) { 
		
		g.setColor(new Color(0, 255, 255));
		g.fillRect(0,0, scaleX, scaleY);
		
		
		g.setColor(Color.RED);

		for (Line l:  LineList) {
			
			System.out.println(l);
			
			g.drawLine((int) (l.p1.x * scaleX),(int) (l.p1.y * scaleY), (int) (l.p2.x * scaleX), (int) (l.p2.y * scaleY));
			
		}
		
//}
		
	}

	public static double avgPathLength(myBST<Line> obj) {
		list = new ArrayList<>();

		preOrdertraversal(obj.root, 0);
		//System.out.println(list.toString());
		double size = (double) list.size();
		double avg = sum / size;
		return avg;
	}
	public void search(MyTreeNode<Line>root,Point p1,Point p2) {
		
		if(root==null) {
			System.out.println("points in the same region ");
			return;
		}

		Line l= root.data;
		
		if(l.magic(p1)==-1) {
			
			//p1 is on the right of the line
			if(l.magic(p2)==-1) {
				//p2 is also on the right side
				
				root=root.rightChild;
				//System.out.println(root.data);
				//calling the search method again to check on the rightChild of the tree now
				if(root!=null)
				 search(root,p1,p2);
				else {
					System.out.println("points in the same region and the current root is null ");
					return;
				}
			}
			else {
				
				//p2 is on the left side
				//have to call a method which will print the node data
				//IMPOOOORTANT
				TesterClass.printNode(root);
				return;
			}
		}
		
		else if(l.magic(p1)==1) {
			//p1 is on the left of line l
			
			if(l.magic(p2)==1) {
				//p2 is on the left of line l
				
				root=root.leftChild;
				//System.out.println(root.data);
				//calling the search method again to check on the leftChild of the tree now
				if(root!=null)
					 search(root,p1,p2);
				else {
					System.out.println("points in the same region");
					return;
				}
			}
			else {
				
				//p2 is on the right side
				//have to call a method which will print the node data
				//IMPOOOORTANT
				TesterClass.printNode(root);
				return;
				
			}
			
		}
		
	}	
}