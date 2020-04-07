# Huffman Code:

Code written by [tado-mi](github.com/tado-mi).

Following is an implementation of the [Huffman coding](https://en.wikipedia.org/wiki/Huffman_coding), as a solution of the assignment for the course **CSC 172** at the University of Rochester. It is made public to demonstrate a code sample by the author, and for learning. We trust it will not be used to violate academic honesty policies.

# Files:

## Node.java

Simple Node class implementing the Comparable interface to compare Nodes by the frequencies of the characters they represent.

**getEncodings():** a recursive method that returns a HashMap, assigning a Character to its Huffman encoding.

## HuffmanCode.java

A class that implements the Huffman coding algorithm. It has two constructors for an encoder(arguments: path to plaintext file) and for a decoder(arguments: path to the frequency file, path to the encoded file). Initializes a HashMap, mapping characters to their frequencies - either by counting from the plaintext, or reading from the frequency file, and creates the Huffman Tree.

# Running:

There is no makefile included. To compile and run, please hit on the terminal:

    javac main.java
    java main file/path

A frequency file, an encoded file and a decoded file will be generated in the same folder as the source code.
