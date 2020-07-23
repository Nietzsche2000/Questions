public class Mon extends Object {

    public int func() {
        System.out.println(1);
        return 1;
    }

    public static class A extends Mon {

        public String func() {
            System.out.println(2);
            return "the";
        }
    }

    public static void main(String[] args) {

    }
}