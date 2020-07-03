public class HardStaticLookup {

    /** Static method lookup */
    public static class A{
        public static int var1 = 1;
        public static int var2 = 2;


        public static void P(int x){
            System.out.println(var1 + ", " + var2);
            System.out.println("I am in P of class A. (1 input)");
        }

        public static void P(int x, int y){
            System.out.println(var1 + ", " + var2);
            System.out.println("I am in P of class A. (2 input)");
        }

        public static void PA(int x){
            System.out.println(var1 + ", " + var2);
            System.out.println("I am method PA from class A. (1 input)");
        }

        public static void PA(int x, int y){
            System.out.println(var1 + ", " + var2);
            System.out.println("I am method PA from class A. (2 input)");
        }
    }

    public static class B extends A {
        public static int var1 = 3;
        public static int var2 = 4;

        public static void P(int x){
            System.out.println(var1 + ", " + var2);
            System.out.println("I am in P of class B. (1 input)");
        }

        public static void P(int x, int y){
            System.out.println(var1 + ", " + var2);
            System.out.println("I am in P of class B. (2 input)");
        }

    }

    public static void main(String[] args) {

        A aa = new A();
        A ab = new B();
        B bb = new B();
        /**
         * aa: static type is A and dynamic type is A --> This call will look at the static type of aa which is a
         * and it will find that there exists a method that takes in one argument of type int and it locks it in
         * then it does not ever look at the dynamic type.
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        aa.P(1); // 1, 2
        /**
         * aa: static type is A and dynamic type is A --> This call will look at the static type of aa which is a
         * and it will find that there exists a method that takes in two arguments of type int and it locks it in
         * then it does not ever look at the dynamic type. (If the method does not exist in the static type class
         * (or a parent and so on ...) then ...
         * ... there will be a compile-time error.
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        aa.P(1, 2); // 1, 2
        /**
         * ab: static type is A and the dynamic type is B --> This call will look at the static type of ab which is a
         * and it will find that there exists a method that takes in one argument of type int and it locks it in
         * then it does not ever look at the dynamic type. (Because static methods only care about static type.)
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        ab.P(1); // 1, 2
        /**
         * ab: static type is A and the dynamic type is B --> This call will look at the static type of ab which is a
         * and it will find that there exists a method that takes in two argument of type int and it locks it in
         * then it does not ever look at the dynamic type. (Because static methods only care about static type.)
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        ab.P(1, 2); // 1, 2
        /**
         * bb: static type is B and the dynamic type is B --> This call will look at the static type of bb which is a
         * and it will find that there exists a method that takes in one argument of type int and it locks it in
         * then it does not ever look at the dynamic type. (Because static methods only care about static type.)
         * ...
         * This will use class B's var because the static type of the variable is B.
         */
        bb.P(1); // 3, 4
        /**
         * bb: static type is B and the dynamic type is B --> This call will look at the static type of bb which is a
         * and it will find that there exists a method that takes in two argument of type int and it locks it in
         * then it does not ever look at the dynamic type. (Because static methods only care about static type.)
         * ...
         * This will use class B's var because the static type of the variable is B.
         */
        bb.P(1, 2); // 3, 4

        /**
         * aa: static type is A and the dynamic type is A --> This will look ONLY at the static
         * type of aa or a super class and if the method is present it will pick that one
         * otherwise raise a compile time error.
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        aa.PA(1); // 1, 2
        /**
         * aa: static type is A and the dynamic type is A --> This will look ONLY at the static
         * type of aa or a super class and if the method is present it will pick that one
         * otherwise raise a compile time error.
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        aa.PA(1,2); // 1, 2
        /**
         * ab: static type is A and the dynamic type is B --> This will look ONLY at the static
         * type of aa or a super class and if the method is present it will pick that one
         * otherwise raise a compile time error.
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        ab.PA(1); // 1, 2
        /**
         * ab: static type is A and the dynamic type is B --> This will look ONLY at the static
         * type of aa or a super class and if the method is present it will pick that one
         * otherwise raise a compile time error.
         * ...
         * This will use class A's var because the static type of the variable is A.
         */
        ab.PA(1,2); // 1, 2
        /**
         * bb: static type is B and the dynamic type is B --> This will look ONLY at the static
         * type of aa or a super class and if the method is present it will pick that one
         * otherwise raise a compile time error.
         * Here there is no PA in B but it extends A so it will "look up" into A to find
         * if there is a new method that exists
         * ...
         * This will use class B's vars because there exists vars for static type B but because there
         * is no method PA in B then it will look up and pick the method from its parent class AND WILL
         * change the static variables.
         */
        bb.PA(1); // 1, 2
        /**
         * bb: static type is B and the dynamic type is B --> This will look ONLY at the static
         * type of aa or a super class and if the method is present it will pick that one
         * otherwise raise a compile time error.
         * Here there is no PA in B but it extends A so it will "look up" into A to find
         * if there is a new method that exists
         * ...
         * This will use class B's vars because there exists vars for static type B but because there
         * is no method PA in B then it will look up and pick the method from its parent class AND WILL
         * change the static variables.
         */
        bb.PA(1,2); // 1, 2

    }
}
