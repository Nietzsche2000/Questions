public class SuperSub {

    public static class A {
        void method1(B x){
            System.out.println("I am in class A, input of static type B");
            A a = new B();
            this.method1((B) a);
        }
    }

    public static class B extends A {
        void method1(A x){
            System.out.println("I am in class B, input of static type A");
        }
    }

    public static class C extends B {
        int x = 100;
        void method1(A x){
            System.out.println("I am in class C, input of static type A");
            B b = new B();
            System.out.println(this.x);
            this.method1(b);
        }
    }

    public static class D extends C {
        void method1(B x){
            System.out.println("I am in class D, input of static type C");
            B b = new B();
            super.method1(b);
        }
    }

    public static class E extends D {
        int x = 10000000;
        void method1(A x){
            System.out.println("I am in class E, input of static type A");
            B b = new B();
            super.method1(b);
        }
    }

    public static void main(String[] args) {
        C c = new E();
        c.method1(c);
    }
}