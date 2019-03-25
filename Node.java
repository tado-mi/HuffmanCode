import java.util.*;

public class Node implements Comparable<Node> {

  String  c; // character
  int     f; // frequency
  Node r, l; // right child, left child

  // constructors
  public Node(String character, int frequency) {

    c = character;
    f = frequency;
    r = null;
    l  = null;

  }

  public Node(Node right, Node left) {

    c = left.c + right.c;
    f = left.f + right.f;

    r = right;
    l = left;

  }

  // toString
  public String toString() {

    String str = "[" + c + ": " + f + "]";
    return str;

  }

  // compare to
  public int compareTo(Node n) {

    if (f < n.f) return -1;
    if (f > n.f) return  1;

    return 0;

  }

  // isLeaf
  public boolean isLeaf() {

    return ((r == null) && (l == null));

  }

  // printing
  public void print() {

    print(0);

  }

  public String line(int n) {

    String ans = "";

    for (int i = 0; i < n; i = i + 1) {

      ans = ans + "     ";

    }

    return ans;

  }

  public void print(int offSet) {

    if (l != null) l.print(offSet + 1);
    System.out.println(line(offSet) + this);
    if (r != null) r.print(offSet + 1);

  }

  public HashMap<Character, String> getEncodings() {

    HashMap<Character, String> encDict = new HashMap<>();
    getEncodings("", encDict);
    return encDict;

  }

  public void getEncodings(String path, HashMap<Character, String> encDict) {

    if (isLeaf()) {

      encDict.put(c.charAt(0), path);

    } else {

      l.getEncodings(path + "0", encDict);
      r.getEncodings(path + "1", encDict);

    }

  }

  public String value() {

    if (c.equals("$")) return "\n";

    return c;

  }

}
