public class generics<T>{

	public void A(){
		System.out.println("Method A");
	}

	// public static void AStatic(T y){
	// 	T x = y;
	// 	System.out.println("Method A, static" + x);
	// }

	public static void main(String[] args) {
		generics<Integer> G = new generics<>();
		G.A();
	}
}