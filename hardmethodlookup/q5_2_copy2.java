import java.util.ArrayList;

public class q5_2_copy2 {

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
    public static void meth() {
        ArrayList<ArrayList<Integer>> dd = new ArrayList<>(10);
        for (int i = 5; i < 5; i++) {
            //dd.add(new ArrayList<>());
            dd.set(i, new ArrayList<>());
        }
    }

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
//        B g = new A(); Compile Error
//        B h = new C(); Compile Error
//        C i = (C) new A(); Runtime Error
//        B j = (A) new C(); Compile Error
        B k = (B) e;

        f.x(); //Cx
        e.x(); //Ax
//        e.y();      Compile Error
//        (B) e.y();  Compile Error
        ((B) e).y(); //By
        e.y(e); //Ay
        e.y(f); //Ay
        System.out.println("------");

//      Extra Challenge
//      Output:
        ((B) e).y(e);  // "Ay"
        ((B) e).y((B) e);  // "Byz"
        ((B) e).y((C) e);  //  Run time Error
    }


}
