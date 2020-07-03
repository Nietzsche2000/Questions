public class HardStaticMethodLookupWithInput {

    public static class Outer extends Object {

        public static void m1(Outer x1, Outer x2) {
            System.out.println("m1 --> Outer");
        }

        public static void m2(Outer x1, Inner x2) {
            System.out.println("m2 --> Outer");
        }

        public static void m3(Inner x1, Outer x2) {
            System.out.println("m3 --> Outer");
        }

        public static void m4(Inner x1, Inner x2) {
            System.out.println("m4 --> Outer");
        }
    }

    public static class Inner extends Outer {

        public static void m1(Outer x1, Outer x2) {
            System.out.println("m1 --> Inner");
        }

        public static void m2(Outer x1, Inner x2) {
            System.out.println("m2 --> Inner");
        }

        public static void m3(Inner x1, Outer x2) {
            System.out.println("m3 --> Inner");
        }

//        public static void m4(Inner x1, Inner x2) {
//            System.out.println("m4 --> Inner");
//        }
    }

    public static void main(String[] args) {

        Outer oo = new Outer();
        Outer oi = new Inner();
        Inner ii = new Inner();

        //Outer oio = (Inner) new Outer();
        Outer ooi = (Outer) new Inner();

//        oo.m1(oo, oo); // m1 --> Outer
//        oo.m1(oo, oi); // m1 --> Outer
//        oo.m1(oi, oo); // m1 --> Outer
//        oo.m1(oi, oi); // m1 --> Outer
//        oo.m1(ii, ii); // m1 --> Outer
//
//        oi.m1(oo, oo); // m1 --> Outer
//        ((Inner) oi).m1(oo, oo); // m1 --> Inner
//        ((Inner) oi).m1((Inner) oi, (Inner) oi);





    }
}
