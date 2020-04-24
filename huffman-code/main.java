public class main {

  public static void main(String[] args) {

    String filename = args[0];
    String encFilename = "encoded.txt";

    HuffmanCode huffmanCode = new HuffmanCode(filename);
    huffmanCode.encode(encFilename);

    huffmanCode = new HuffmanCode(encFilename, huffmanCode.freqFilename);
    huffmanCode.decode("out_" + filename);

  }

}
