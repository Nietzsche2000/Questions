package TwoDArrays;

public class Function<T>{

    int start;

    public Function(int start){
        this.start = start;
    }
    public Function<T> add(Function<T> x){
        int y = x.start;
        start = y + start;
        return new Function<T>(start);
    }
}