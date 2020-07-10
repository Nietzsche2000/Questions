public class ConcreteClass extends AbstractClasses{

//    private int x = 100;

    public ConcreteClass(){}

    @Override
    public void method() {
        System.out.println("Concrete class method " + this.x);
    }

    public static void main(String[] args) {
        AbstractClasses ac = new ConcreteClass();
        ac.method();
    }
}
