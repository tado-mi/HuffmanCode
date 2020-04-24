# variable for java compiler
JC = javac
J = java
D = -d
CD = cd

# damage control
.SUFFIXES: .java .class

# target for creating .class from .java in format:
#	.original_extention.target_extention:
#		rule
.java.class:
	$(JC) $*.java $(D) bin

# macro for each java source file
CLASSES = \
	src/Tree.java \
	src/Line.java \
	src/Point.java \
	src/LineLocator.java \
	src/LocatorGUI.java \
	Demo.java

# default target definition
default: classes

classes: $(CLASSES:.java=.class)

test:
	$(CD) bin && $(J) Demo ../test.txt

.PHONY: clean
clean:
	$(RM) -rf bin/
