public class fib extends Object {

    public static int fib(int number) {
        if (number <= 1) {
            return number;
        }
        return fib(number-1) + fib(number-2);
    }
    public static void main(String[] args) {
        System.out.println((fib.fib(0)));
    }
}