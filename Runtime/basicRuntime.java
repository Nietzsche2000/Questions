public class basicRuntime {

    public static int problem1(int x){
        int f = 0;
        if(x == 0)
            return 10;
        for(int i = 0; i < x; i++){
            f += problem1(x/2) + problem1(x - 1);
            x = x/2;
        }
        return f;
    }

    public static void main(String[] args) {
        problem1();
    }

}