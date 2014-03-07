package stuff;

public class MyOtherConcreteThing extends MyAbstractThing {

    public MyOtherConcreteThing(int f, int b) {
	super(f, b);
    }

    @Override
    public void doStuff(int f) {
	System.out.println("works from java");
    }

}
