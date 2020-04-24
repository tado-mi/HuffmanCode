// for the use of HashMap
import java.util.*;

// for the use of File
import java.io.*;

public class HuffmanCode {

  String freqFilename, inFilename;
  Node   huffmanTree;

  HashMap<Character, Integer> freqList;

  // encoder
  public HuffmanCode(String filename) {

    this.inFilename   = filename;
    this.freqList     = new HashMap<>();

    countFreq();  // initialise frequency record and freqList
    createTree(); // create the Huffman tree

  }

  // decoder
  public HuffmanCode(String filename, String freqFilename) {

    this.freqFilename = freqFilename;
    this.inFilename   = filename;
    this.freqList     = new HashMap<>();

    createFreqList();   // initialise the frequency hashmap
    createTree();       // create the Huffman tr

  }

  // returns a String with the contents of the file with filename
  public String getContent(String filename){

    try {

      Scanner scanner = new Scanner(new FileReader(filename));
      String  ans = "";

      while(scanner.hasNext()) {

        String temp = scanner.nextLine();
        ans = ans + temp + "$";

      }

      return ans;

    } catch (FileNotFoundException e) {

      System.out.println("File " + filename + " not found.");
      return null;

    }

  }

  public void write(String content, String filename) {

    try {

      BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

      writer.write(content);
      writer.newLine();
      writer.close();

    } catch (IOException e) {


    }


  }

  // counts frequencies of all the characters of the content of the inFile
  // saves the hashmap in an external file, returns the filename
  public void countFreq() {

    String str = getContent(inFilename);

    for (int i = 0; i < str.length(); i = i + 1) {

      char c = str.charAt(i);
      int  f = 1;
      if (freqList.containsKey(c)) f = f + freqList.get(c);

      freqList.put(c, f);

    }

    recordFreq();

  }

  // records the frequencies into an external file named freqFilename
  public void recordFreq() {

    freqFilename = "freq_" + inFilename.split(".txt")[0];

    try {

      BufferedWriter writer = new BufferedWriter(new FileWriter(freqFilename));

      for (char c: freqList.keySet()) {

        int f = freqList.get(c);
        String temp = c + ":" + f;

        writer.write(temp);
        writer.newLine();

      }

      writer.close();

    } catch (IOException e) {


    }

  }

  // initialises the freqList from freqFile
  public void createFreqList() {

    try {

      Scanner scanner = new Scanner(new FileReader(freqFilename));

      while(scanner.hasNext()) {

        String   temp = scanner.nextLine();
        String[] arr  = temp.split(":");
        freqList.put(arr[0].charAt(0), Integer.parseInt(arr[1]));

      }

    } catch (FileNotFoundException e) {

      System.out.println("File " + freqFilename + " not found.");

    }

  }

  public void createTree() {

    PriorityQueue<Node> q = new PriorityQueue<>();
    for (Character c: freqList.keySet()) {

      String s = c + "";
      int    f = freqList.get(c);
      Node n = new Node(s, f);
      q.add(n);

    }

    while (q.size() > 1) {

      Node n1 = q.poll();
      Node n2 = q.poll();

      Node n3 = new Node(n1, n2);
      q.add(n3);

    }

    huffmanTree = q.poll();

  }

  public void encode(String outFilename) {

    // get encodings
    HashMap<Character, String> encDict = huffmanTree.getEncodings();
    String enc = "";

    String in = getContent(inFilename);
    for (int i = 0; i < in.length(); i = i + 1) {

      char c = in.charAt(i);
      String s = encDict.get(c);
      enc = enc + s;

    }

    write(enc, outFilename);

  }

  public void decode(String outFilename) {

    String dec = "";
    Node   n = huffmanTree;

    String in = getContent(inFilename);
    for (int i = 0; i < in.length(); i = i + 1) {

      char c = in.charAt(i);

      if (c == '0') n = n.l;
      else          n = n.r;

      if (n.isLeaf()) {

        dec = dec + n.value();
        n = huffmanTree;

      }

    }

    write(dec, outFilename);

  }

}
