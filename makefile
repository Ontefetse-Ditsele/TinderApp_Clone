# Makefile 
# Ontefetse Ditsele

# A simple Makefile
# HelloWorld.class: HelloWorld.java
# javac HelloWorld.java

SRCDIR = src
BINDIR = bin
DOCDIR = doc
TESTDIR = test

JUNIT = ./src ./src/$*.java


JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR)

#to check the src and test folders for the .java files
#also to ensure that class files are in bin 
vpath %.java $(SRCDIR):$(TESTDIR)
vpath %.class $(BINDIR)

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $<

classes: Person.class Profile.class Image.class Database.class TinderSwipe.class \
		TinderApp.class

default: $(CLASSES)

doc:
	javadoc -d $(DOCDIR) -cp $(DOCDIR) $(SRCDIR)/*.java

test_classes: Person.class Profile.class Image.class Database.class TinderSwipe.class \
			TinderApp.class 
	      
junit: test_classes
	
Person.class: Person.java
	javac -d $(BINDIR) -cp $(JUNIT)
Profile.class: Profile.java
	javac -d $(BINDIR) -cp $(JUNIT)
Image.class: Image.java
	javac -d $(BINDIR) -cp $(JUNIT)
Database.class: Database.java
	javac -d $(BINDIR) -cp $(JUNIT)
TinderSwipe.class: TinderSwipe.java
	javac -d $(BINDIR) -cp $(JUNIT)
TinderApp.class: TinderApp.java
	javac -d $(BINDIR) -cp $(JUNIT)

clean:
	rm -f  $(BINDIR)/*.class
	rm -Rf doc
	rm -f $(BINDIR)/swipes.csv