public abstract class AbstractClasses {

    /**
     * Abstract classes can have a constructor.
     * Abstract classes can have normal as well as abstract methods.
     * A class can only extend another class.
     * Abstract class, like any other class, can have instance fields.
     */
    
    public int x = 100;

    public AbstractClasses() {
        x = 50;
    }

    public abstract void method();

    public void method1() {
        System.out.println("Abstract class method.");
    }

}