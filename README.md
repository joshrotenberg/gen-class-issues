# gen-class-issue

I was trying to use gen-class to extend an abstract class and ran into
an issue with getting a duplicate method error when I run it. This
repo basically displays the issue.

There is a Java class: stuff.MyAbstractThing. I use gen-class to
extend it in Clojure, and there is a concrete version in Java as well.

The doStuff in stuff.MyAbstractThing seems to be the issue. If I use
javap to print out the signature of my compiled class, I see two identical versions of the function:

```java
(saucy)josh@localhost:~/github/gen-class-issue$ javap -classpath `lein classpath` stuff.MyConcreteThing
public class stuff.MyConcreteThing extends stuff.MyAbstractThing {
  public final java.lang.Object ma-state;
  public static {};
  public stuff.MyConcreteThing(int, int);
  public java.lang.Object clone();
  public int hashCode();
  public java.lang.String toString();
  public boolean equals(java.lang.Object);
  public int getBar();
  public int getFoo();
  public void doStuff(int);
  public void doStuff(int);
  public static void main(java.lang.String[]);
}
```

But not in the Java version:

```java
(saucy)josh@localhost:~/github/gen-class-issue$ javap -classpath `lein classpath` stuff.MyOtherConcreteThing
Compiled from "MyOtherConcreteThing.java"
public class stuff.MyOtherConcreteThing extends stuff.MyAbstractThing {
  public stuff.MyOtherConcreteThing(int, int);
  public void doStuff(int);
}
```
