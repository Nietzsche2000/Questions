public class ryanClearup {
	int x = 6;
	public void ryan(){
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
		ryanClearup A = new ryanClearup();
		A.ryan();
	}
}