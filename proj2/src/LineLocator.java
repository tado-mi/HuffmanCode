import java.io.*;
import java.util.*;

public class LineLocator  {

  public Tree<Line> root;
  Point p1, p2;

  public LineLocator(String filename) {

    Scanner scan;

    try {
      scan = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.out.println(" ---- file " + filename + " was not found ---- ");
      return;
    }

    root = new Tree<Line>();

    int n = scan.nextInt();
    for (int i = 0; i < n; i = i + 1) {

      double x = scan.nextDouble();
      double y = scan.nextDouble();
      Point p = new Point(x, y);

      x = scan.nextDouble();
      y = scan.nextDouble();
      Point q = new Point(x, y);

      root.insert(new Line(p, q));

    }

  }

  protected Line search() {

    if (root == null || p1 == null || p2 == null) {
      return null;
    }

    Line l = root.data;
    int RIGHT = Line.RIGHT, LEFT = Line.LEFT;

    if (p1.sideOf(l) == RIGHT) {

      if (p2.sideOf(l) == RIGHT) {

        root = root.rightChild;
        // if (root == null) {
        //   return "points in the same region";
        // }
        return search();

      }

    } else if (p1.sideOf(l) == LEFT) {

      if (p2.sideOf(l) == LEFT) {

        root = root.leftChild;

        // if (root == null) {
        //   return "points in the same region";
        // }
        return search();

      }

    }

    return l;

  }

  public Line locate(Point p1, Point p2) {

    this.p1 = p1;
    this.p2 = p2;

    Tree<Line> tree = root;
    Line l = search();

    // restore the tree to its root
    root = tree;

    // unassign p1 and p2
    this.p1 = null;
    this.p2 = null;

    if (l == null) {
      System.out.println("points in the same region ");
    } else {
      System.out.println("points are separated with " + l.toString());
    }

    return l;

  }

  // public static double avgPathLength() {
  //
  //   List list = root.getList();
  //
  //   double size = (double) list.size();
  //   double sum = 10.0;
  //   double avg = sum / size;
  //
  //   return avg;
  //
  // }


}
