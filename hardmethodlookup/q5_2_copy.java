public class q5_2_copy {

/*    Compile Time:
    1. Declare Static Type
    2. Find if a funtion with matching signature exist
    3. Record the signature down

    Run Time:
    4. Check if runtime class type has a function with the recorded signatur
        - If not, runtime Error
        - If exists, see if a non-static function(with the same signature as above) overrides the the function
            - if exists, run the overriding function.

     Note: Always choose the most **specific function possible!
        */

    public static class A {
        public void x() {
            System.out.println("Ax");
        }

        public void y(A z) {
            System.out.println("Ay");
        }
    }

    public static class B extends A {
        public void y() {
            System.out.println("By");
        }

        public void y(B z) {
            System.out.println("Byz");
        }

        public void y(C z2) {
            System.out.println("Czz");
        }

    }


    public static class C extends A {
        public void x() {
            System.out.println("Cx");
        }
    }

    public static class D {
        public void z () {
            System.out.println("Dx");
        }
    }

    public static void main(String[] args) {
        A e = new B();
        A f = new C();
        //B g = new A();
        //B h = new C();
        //C i = (C) new A();
        //B j = (A) new C();
        B k = (B) e;

        f.x();
        e.x();
        //e.y();
        //(B) e.y();
        ((B) e).y();
        e.y(e);
        e.y(f);
        System.out.println("------");

//      Extra Challenge
//      Output:
        ((B) e).y(e);
        ((B) e).y((B) e);
        //((B) e).y((C) e);
    }


}
