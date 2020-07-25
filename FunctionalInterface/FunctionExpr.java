import java.util.Arrays;

public class FunctionExpr {


    //    @FunctionalInterface
    public interface addOne<T, U, R> {
        public int apply(T x, U y);

        default int f1() {
            System.out.println("h");
            return 0;
        }
    }

    public static abstract class A<T1, U1, R1> implements addOne<T1, U1, R1> {

        @Override
        public int apply(T1 x, U1 y) {
            System.out.println("I am in class A apply x: " + x + " y: " + y);
            return -1;
        }
    }

    public static class addOneC<T1, U1, R1> extends A<T1, U1, R1> implements addOne<T1, U1, R1> {
//
//
//        @Override
//        public R1 apply(T1 x, U1 y) {
//            System.out.println("I am in addOneC apply x: " + x + " y: " + y);
//            return null;
//        }

    }


    /**
     * How does java know that it is a bi-function or a function even without explicitly saying
     * implements the aforementioned.
     * the static type that holds the apply method must be a functional interface.
     *
     * @param args
     */

    public static void main(String[] args) {
        A<Integer, Integer, Integer> f1 = new addOneC<>();
        addOne<Integer, Integer, Integer> L = f1; // wth?
        Integer[] a = {100, 1, 2, 3, 4, 5, 6, 7};
        Arrays.sort(a, f1::apply);
        System.out.println(Arrays.toString(a));

////        addOne f1 = (x, y) -> x + y;
//        addOneC c = new addOneC();
//        addOne f1 = c::doTwice;
////        addOneC.doTwice(f1, 10);
////        System.out.println(f1.apply(100, 100));
    }

}