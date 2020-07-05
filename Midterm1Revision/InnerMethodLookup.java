public class InnerMethodLookup {

    public static class A {

        public void one(){
            System.out.println("I am in class A method one.");
            A a = new A();
            two(a);
        }

        public void two(A a){
            System.out.println("I am in class A method two.");
        }
    }

    public static class B extends A {

        public void one(){
            System.out.println("I am in class B method one.");
            two1();
        }

        public void two1(){
            System.out.println("I am in class B method two.");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A ab = new B();
        ab.one();
    }
}
