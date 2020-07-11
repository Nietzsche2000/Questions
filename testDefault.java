public class testDefault {

    int x;

    public void method() {
        int x;
        System.out.println(this.x);
        System.out.println(x);
    }

    public static void main(String[] args) {
        testDefault xx = new testDefault();
        xx.method();
    }
}