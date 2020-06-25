public class OperatorPrecedence{

	/** Instance Variables */
	public int x;
	public int y;

	public OperatorPrecedence(int x, int y){
		this.x = x;
		this.y = y;
	}

 	/** ++ ON THE RIGHT */
 	public void plusPlusRight(){
 		int p = x++;
 		System.out.println(p);
 	}

 	/** ++ On the left */
 	public void plusPlusLeft(){
 		int p = ++x;
 		System.out.println(p);
 	}

 	/** Ternary operators--If else in one line */
 	public void ternaryOperator(){
 		int x = 1;
 		int y = 2;
 		int z = x < y ? x: y; //--> why is this operator right to left.
		System.out.println(z);
	}
	/** Bitwise operators */
	public void bitwiseOperator(){
		int x = 2;
		int y = 2;
		if(x > 3 & x < y++) {
			System.out.println(2);
		}
		System.out.println(y);
		y &= 2; // --> y = 3 --> 11, 2 --> 10, BITWISE AND 11 & 10 --> 10
		System.out.println(y);
	}


 	public static void main(String[] args) {
 		OperatorPrecedence test1 = new OperatorPrecedence(1, 2);
// 		test1.plusPlusRight();
// 		test1.plusPlusLeft();
// 		test1.ternaryOperator();
		test1.bitwiseOperator();
 	}
}