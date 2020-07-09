public class AccessModifier {

    public static class A {
        private int x;

        public A() {
            x = 100;
            this.method();
        }

        public void method() {
            System.out.println("A");
        }


    }

    public static class B extends A {

        public B() {
            super();
            System.out.println(super.x);
            super.x = 10;
            System.out.println(super.x);
            super.method();
        }

        public void Test() {
            super.method();
        }

        public void method() {
            System.out.println("B");
        }

//        void method(){
//            System.out.println(this.x);
//        }

        public static void main(String[] args) {
            B b = new B(); //--> B 100 10 A
//            b.Test();
//            System.out.println(b.x);
//            b.method();
        }
    }
}
