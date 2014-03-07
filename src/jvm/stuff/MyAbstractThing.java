package stuff;

public abstract class MyAbstractThing {

    private final int foo;
    private final int bar;

    protected MyAbstractThing(int foo,
			      int bar) {
	this.foo = foo;
	this.bar = bar;
    }

    public abstract void doStuff(int baz);

    protected int getFoo() {
	return foo;
    }

    protected int getBar() {
	return bar;
    }

}
