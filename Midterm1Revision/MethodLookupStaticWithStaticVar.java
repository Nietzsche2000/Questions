public class MethodLookupStaticWithStaticVar {

    /** Static method lookup */
    public static class A{

        public static String X = "Class A static var X";
        public static String Y = "Class A static var Y";

        public static void P(){
            System.out.println("I am in P of class A");
        }

        public static void PA(){
            System.out.println("I am method PA from class A.");
        }
    }

    public static class B extends A {
        public static String X = "Class B static var X";
        public static String Y = "Class B static var Y";

        public static void P(){
            System.out.println("I am in P of class B");
        }

    }

    public static void main(String[] args) {
        A a = new A();
        A ab = new B();
        B b = new B();

        /** Output Justification:
         * JVM looks at the static type, checks whether there exists an static variable/instance variable of the same name.
         * If it does not exist, JVM issues a compile time error.
         * Output: Class A var X
         */
        System.out.println(a.X);
        /**
         * a.Y, Output: Class A var Y
         */
        System.out.println(a.Y);
        /**
         * b.X, Output: Class B var X
         */
        System.out.println(b.X);
        /**
         * b.Y, Output: class B var Y
         */
        System.out.println(b.Y);

        /**
         * ab.X, Output: class A var X
         */
        System.out.println(ab.X);
        /**
         * ab.Y, Output: class A var Y
         */
        System.out.println(ab.Y);
    }

}
