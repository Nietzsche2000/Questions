public class MethodLookup{

    /** Static method lookup */
    public static class A{


        public static void P(){
            System.out.println("I am in P of class A");
        }

        public static void PA(){
            System.out.println("I am method PA from class A.");
        }
    }

    public static class B extends A{

        public static void P(){
            System.out.println("I am in P of class B");
        }

    }

    public static void main(String[] args) {

        A a = new A(); // static type: A, dynamic type: B
        A ab = new B(); // static type: A, dynamic type: B
        B b = new B(); // static type: B, dynamic type: B

        /** Output Justification: a.P() --> static type of a is A, the JVM checks whether there exists a P named method
         * of the parameter type nothing. There exists, JVM approves.
         * During runtime, execute what was discovered at compile time.
         * Output: run method P from A.
         */
        a.P();

        /** Output Justification: ab.P() --> Static type of ab is A, the JVM checks whether there exists a P named method
         * of the parameter type nothing. There exists, JVM approves.
         * During runtime, run what was chosen at static lookup during compile time.
         * Output: run method P from A.
         */
        ab.P();

        /** Output Justification: b.P() --> Static tyoe of b is B, the JVM checks whether there exits a P named method
         * of parameter type nothing. There exist, JVM approves.
         * During runtime, execute what was selected during compile time.
         * Output: run method P form B.
         */
        b.P();

        /** Output Justification: A.PA() --> static type of class A, JVM checks whether method PA of none parameter exits,
         * and it exists, therefore fixes it.
         * Output: PA method from class A;
         */
        A.PA();
        /** Output Justification: B.PA() --> Static type of class B, JVM checks whether method PA of none parameter exits
         * it does not. Therefore, it lookups the inheritance chain. There exists one in A. JVM fixes that.
         * Output: run method PA from class A.
         */
        B.PA();
    }
}