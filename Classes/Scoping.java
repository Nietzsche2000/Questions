public class Scoping {
	int x = 6;
	public void method1(){
		int y = 10;
		class K {
			int z = 7;

			public K(){
				this.z = x;
			}
			void printer(){
				System.out.println(x); // Very Dangerous.
			}
		}

		K k = new K();
		k.printer();
	}

	public static void main(String[] args) {
		Scoping scop = new Scoping();
		scop.method1();
	}
}