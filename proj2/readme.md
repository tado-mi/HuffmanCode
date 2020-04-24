# Project 2

Code written by *Anisha Bhattacharya* and *Godbless Chille*.

Following is an implementation of a **Line Comparator**, as a solution of the assignment for the course **CSC 172** at the University of Rochester. It is made public to demonstrate a code sample by the author, and for learning. We trust it will not be used to violate academic honesty policies.

# Files

For this project, we implemented 6 different classes.

## Point.java
This class consists of the fundamentals of what makes a point, that is, the `x` and `y` coordinates which are used to create one line. It also consists of methods that check whether a point is to the left or the right with respect to another line

## Line.java
This class consists of methods that fundamentally make a line. The Line consists of two points and these are the ones that make up a line. The class also contains a wide array of methods whose functionality is well explained in the class itself,
One of the most important however is the `compareLines()` methods which takes in points and checks whether or not they are lines.

## MyTreeNode.java
This has been used in the previous lab (Lab10). It basically contains data and the children as well as the root.

## myBST.java
This is the tree itself

## TesterClass.java
This class contains few methods. It has **Graphical User Interface** for this project adn also contains a method to read from the `textFile`. Lines are being inserted here and the comparison of the lines is also made here

# Running
Compile them and then run `TesterClass.java` on terminal by typing `java TesterClass ReadFile.txt`. The result should be a couple of red lines on a blue rectangle (for EXTRA CREDIT).

* Think of the rectangle as a unit square so we managed to scale our lines and the rectangle so that it looks like that!!!
* Click between two lines, click inside a region bounded by lines, and check the console
* It should display `points bounded by the same region` if they are in the same region of lines
* Or `points are separated by a line` if they are not in the same region
* Also try to put your own lines(within the unit square) as we designed it (20 points)

Thanks.
