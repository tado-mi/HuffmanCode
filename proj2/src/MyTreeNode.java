
public class MyTreeNode<T extends Comparable<T>> {
	public T data;
	public MyTreeNode<T> leftChild;
	public MyTreeNode<T> rightChild;
	public  MyTreeNode<T> parent;
	public MyTreeNode<T> mynode;
	public Point Var = new Point(0, 0);
	int COUNTERCLOCKWISE =-1;
	int CLOCKWISE =1;
	int COLINEAR=0;
	public MyTreeNode(){

	}
	public MyTreeNode(T data){
		this.data=data;
	}
	public String toString() {
		return (String)parent.data;
	}



	public void preOrdertraversal(MyTreeNode<T> parent) {
		if (parent != null) {
			System.out.println(parent.data);

			preOrdertraversal(parent.leftChild);
			preOrdertraversal(parent.rightChild);

		}
	}


	public void postOrdertraversal(MyTreeNode parent) {
		if (parent != null) {

			postOrdertraversal(parent.leftChild);
			postOrdertraversal(parent.rightChild);
			System.out.println(parent.data);

		}

	}

	public void inOrdertraversal(MyTreeNode<T> parent, int count) {
		if (parent != null) {

			inOrdertraversal(parent.leftChild,count+1);
			for(int i=0;i<count;i++) {
				System.out.print(" ");
			}
			System.out.println(parent.data);
			inOrdertraversal(parent.rightChild,count+1);

	}
	}
	public MyTreeNode<T> delete(MyTreeNode<T> node, T x) {

		if (node == null)
			throw new NullPointerException();
		else if (compare(x, node.data) < 0) {
			node.leftChild = delete(node.leftChild, x);
		} else if (compare(x, node.data) > 0) {
			node.rightChild = delete(node.rightChild, x);
		} else if (node.leftChild == null)
			return node.rightChild;
		else if (node.rightChild == null)
			return node.leftChild;
		else {
			// get data from the leftmost node in the right sub-tree
			node.data = retrieveData(node.rightChild);
			// delete the node that has been retrieved by the above method
			node.leftChild = delete(node.leftChild, node.data);
		}
		return node;

	}

	private T retrieveData(MyTreeNode<T> k) {
		while (k.leftChild != null)
			k = k.leftChild;
		return k.data;
	}

	public void insert(T x) {

		// MyTreeNode newNode = new MyTreeNode();
		if (data== null) {
			// root = new MyTreeNode<T>();
			data = x;
			return;
		}

//		MyTreeNode<T> node = new MyTreeNode<T>();
//		node.data = x;

		if (compareUS((Line)x,(Line)data) > 0) {
			if (leftChild == null) {
				leftChild = new MyTreeNode<T>(x);
			} else {
				leftChild.insert(x);
			}

		} else if (compareUS((Line)x,(Line)data) < 0) {
			if (rightChild == null) {
				rightChild = new MyTreeNode<T>(x);
			} else {
				rightChild.insert(x);
			}
		} else {

			if (leftChild == null) {
				leftChild = new MyTreeNode<T>(x);
			} else {
				leftChild.insert(x);
			}

			if (rightChild == null) {
				rightChild = new MyTreeNode<T>(x);
			} else {
				rightChild.insert(x);
			}

		}

	}

	public int compareUS(Line L, Line K) {
		return L.compareTo(K);

	}
	private int compare(T d1, T d2) {

		if (d1.compareTo(d2)== 0) {
			return 0;
		} else if (d1.compareTo(d2) < 0) {
			return -1;
		} else if(d1.compareTo(d2) > 0) {
			return 1;
		}
		return -2;
	}
//	public MyTreeNode<Line> search(myBST<Line> parent,Point p1,Point p2) {
//		System.out.println("working.....");
//		return search(parent.root,p1,p2);
//
//
//	}

//	public MyTreeNode<Line> search(MyTreeNode<Line> root,Point p1,Point p2) {
//
//		if(root==null) {
//			System.out.println("points in the same region ");
//			return null;
//		}
////		int s1 = ccw()
//		Line l= root.data;
//
//		if(l.magic(p1)==-1) {
//
//			//p1 is on the right of the line
//			if(l.magic(p2)==-1) {
//				//p2 is also on the right side
//				System.out.println("Both points on the RIGHT");
//				root=root.rightChild;
//				//calling the search method again to check on the rightChild of the tree now
//				 search(root,p1,p2);
//
//			}
//			else {
//				System.out.println("first else is hereeee");
//				//p2 is on the left side
//				//have to call a method which will print the node data
//				//IMPOOOORTANT
//				TesterClass.printNode(root);
//				return null;
//			}
//		}
//
//		else if(l.magic(p1)==1) {
//			//p1 is on the left of line l
//
//			if(l.magic(p2)==1) {
//				//p2 is on the left of line l
//				System.out.println("Both points on the leftttttt");
//				root=root.leftChild;
//				//calling the search method again to check on the leftChild of the tree now
//				 search(root,p1,p2);
//			}
//			else {
//				System.out.println("printNode hereeeeee");
//				//p2 is on the right side
//				//have to call a method which will print the node data
//				//IMPOOOORTANT
//				TesterClass.printNode(root);
//				return null;
//
//			}
//
//		}
//		return root;
//	}
//	}
//		int search1 = ccw(p1,root.data.p1, root.data.p2); // generating two sides
//        int search2 = ccw(p2,root.data.p1, root.data.p2);
//
//
//        while(search1==search2){
//            if(search1==CLOCKWISE){
//                System.out.println("Moving Clockwise");
//               // System.out.println(parent.rightChild.data);
//                if(root.rightChild==null) {	// if both the regions are same, they are found in the same region ( in the leaf).{
//                	//TesterClass.printNode(root);
//                	return null;}
//                else {
//                	//TesterClass.printNode(root);
//                    root=root.rightChild;	//keeping track of branches
//                }
//
//            }
//
//            else if(search2==COUNTERCLOCKWISE){
//                System.out.println("Moving AntiClockwise");
//                if(root.leftChild==null) { //means they are found
//                	//TesterClass.printNode(root);
//                	return null;
//                }
//                else {
//                	//TesterClass.printNode(root);
//                    root=root.leftChild;} //keeping track of branches
//
//            }
//
//            search1=ccw(p1,root.data.p1, root.data.p2);
//            search2=ccw(p2,root.data.p1, root.data.p2); // new search1 and search2 and use of recursion to go over same path in other subtree.
//        }
//        return root;
//	}
	int ccw(Point p0, Point p1, Point p2) {
		 double dx1 = p1.x - p0.x;
		 double dy1 = p1.y - p0.y;
		 double dx2 = p2.x - p0.x;
		 double dy2 = p2.y - p0.y;
		 if (dx1*dy2 > dy1*dx2) return COUNTERCLOCKWISE;
		 else if (dx1*dy2 < dy1*dx2) return CLOCKWISE;
		 else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return CLOCKWISE;
		 else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return COUNTERCLOCKWISE;
		 else return COLINEAR;
		}

}
