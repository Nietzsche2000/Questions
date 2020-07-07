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
				x = 10; // field attribute changing. 
				System.out.println(x); // Very Dangerous. Ask Matt. Is java, like python, Lexically scoped? 
				//System.out.println(this.x); // Is this implicit on inner method/field scope?
			}
		}

		K k = new K();
		k.printer();
	}

	public static void main(String[] args) {
		Scoping scop = new Scoping();
		scop.method1();
		System.out.println(scop.x);
	}
}