package TwoDArrays;

public class TwoDArraysPractice<T>{

	public Function<T>[][] items;
	public int row;
	public int column;

	public TwoDArraysPractice(int r, int c){
		row = r;
		column = c;
		items = new Function<T>[row][column];
	}

	/** Add data based on the Function */
	public void addData(Function<T> start){
		Function<T> c = start;
		for(int i = 0; i < row; i++){
			for(int j = 0; i < column; j++){
				items[i][j] = start;
				c = c.add(c);
			}
		}
	}


	/** Driver Main method for TwoDArrays */
	public static void main(String[] args) {
		TwoDArraysPractice<Integer> TD = new TwoDArraysPractice<>(5, 5);
		TD.addData(new Function<>(1));
	}
	
}