package TwoDArrays;


/** Function class to be used in TwoDArrays */
public class Function<T>{

    int start;

    public Function(int start){
        this.start = start;
    }

    /** Simple add method for TwoDArrays */
    public Function<T> add(Function<T> x){
        int y = x.start;
        start = y + start;
        return new Function<T>(start);
    }
}