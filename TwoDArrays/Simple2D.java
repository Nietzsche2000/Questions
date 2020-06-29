public class Simple2D{

	/** Member variables for Simple2D */
	int[][] matrix;
	int row;
	int column;

	public Simple2D(int r, int c){
		row = r;
		column = c;
		matrix = new int[row][column];
	}

	/** Testing program to add ordered-arbitary integers */
	public void add(){
		int c = 0;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				matrix[i][j] = c;
				c++;
			}
		}
	}

	@Override
	public String toString(){
		StringBuilder a = new StringBuilder();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				a.append(matrix[i][j] + " ");
			}
			a.append("\n");
		}
		return a.toString();
	}

	/** Adding another matric to this */
	public int[][] addOther(Simple2D other){
		if(other.row != row || other.column != column)
			return matrix;
		for(int r = 0; r < row; r++){
			for(int c = 0; c < column; c++){
				matrix[r][c] += other.matrix[r][c];
			}
		}
		return matrix;

	}

	/** Return the respective column vector in the matrix */
	public int[] getCol(int index){
		int[] items = new int[column];
		for(int j = 0; j < row; j++)
			items[j] = matrix[j][index];
		return items;
	}


	/** Multiply the other matrix to this */
	public int[][] multiplyOther(Simple2D other){
		int[][] temp = new int[row][column];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				int val = 0;
				for(int k = 0; k < column; k++){
					 val += matrix[i][k] * other.matrix[k][j];
				}
				temp[i][j] = val;
			}
		}
		matrix = temp;
		return matrix;

	}

	/** Driver main method for Simple2D */
	public static void main(String[] args) {
		Simple2D TD = new Simple2D(2, 2);
		TD.add();
		System.out.println(TD);
		TD.multiplyOther(TD);
		System.out.println(TD);
	}
}