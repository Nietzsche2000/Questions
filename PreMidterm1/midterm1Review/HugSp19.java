public class HugSp19 {

    public interface ComFunc {
        int apply(int a, int b); // apply(a, b) must equal apply(b, a)
    }

    public static class Combine {
        public static int combine(ComFunc f, int[] x) {
            if (x.length == 0) {
                return 0;
            }
            if (x.length == 1) {
                return x[0];
            }
            return helper(f, x, x[0], 1);
        }

        public static int helper(ComFunc f, int[] x, int soFar, int i) {
            if (i >= x.length)
                return soFar;
            soFar = f.apply(x[i], soFar);
            return helper(f, x, soFar, i + 1);
        }
    }

    public static class Add implements ComFunc {
        public int apply(int a, int b) {
            return a + b;
        }
    }

    public static int sumAll(int[] x) {
        return Combine.combine(new Add(), x);
    }


    interface A {
        default void method1() {
            System.out.println("I am in interface method.");
        }
    }

    public static class B implements A {
        @Override
        public void method1() {
            System.out.println(" I am in class B method 1.");
        }

        public B() {
        }

        public static void main(String[] args) {
            A a = new B();
            a.method1();
        }
    }


    public static void main(String[] args) {
//        int[] x = {1, 2, 3, 4};
//        int[] y = {0, 0, 1};
//        System.out.println(sumAll(x) == 10);
//        System.out.println(sumAll(y) == 1);
    }

}
