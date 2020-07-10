public class basicRuntime {
    static int result = 0;

    public static int problem1(int x) {
        int f = 0;
        if (x == 0)
            return 10;
        for (int i = 0; i < x; i++) {
            f += problem1(x / 2) + problem1(x - 1);
            x = x / 2;
            result++;
        }
        return f;
    }

    public static void main(String[] args) {
        /** */
        long x = problem1(300);
        System.out.println(basicRuntime.result);
    }

}