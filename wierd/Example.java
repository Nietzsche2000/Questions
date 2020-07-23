public class Example extends Object {

    public Example function(Example input) {
        System.out.println("outside method");
        return null;
    }

    public static class Example2 extends Example {

        public Example2 function(Example input) {
            System.out.println("inside method");
            return null;
        }
    }

    public static void main(String[] args) {
        Example ex = new Example2();
        ex.function(null);
    }
}