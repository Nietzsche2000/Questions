public class InnerMethodLookup {

    public static class A {

        public void one(){
            System.out.println("I am in class A method one.");
            A a = new B();
            two(a);
        }

        public void two(A b){
            System.out.println("I am in class A method two.");
            b.one();
        }
    }

    public static class B extends A {

        public void one(){
            System.out.println("I am in class B method one.");
            B a = new B();
            two(a);
        }

        public void two(B b){
            System.out.println("I am in class B method two.");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A ab = new B();
        ab.one();
    }
}
