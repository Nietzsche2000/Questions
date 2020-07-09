public class TypeDispatch{

	public static class A {
        public void x() {
            System.out.println("Ax. I am in class A. ");
        }

        // public void y(B z) {
        //     System.out.println("Ay");
        // }
    }

    public static class B extends A {
        public void y() {
            System.out.println("By. I am in class B.");
        }

        public void y(A x) {
            System.out.println("Bx. I am in class B.");
        }

        // public void y(B z) {
        //     System.out.println("Byz");
        // }

        // public void y(C z2) {
        //     System.out.println("Czz");
        // }

    }


    public static class C extends A {
        public void x() {
            System.out.println("Cx. I am in class C.");
        }

        public void y(A x) {
            System.out.println("Cx. I am in class C.");
        }
    }

    public static void main(String[] args) {
    	A e = new B(); // --> Static type of e is A, and the dynamic type of e is B. 
        ((B) e).y((B) e);
    }
}