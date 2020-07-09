public class QuestionArray<T>{
		public test[] a;

		public class test{
			T item;
			public test(T x){
				item = x;
			}

			public void methodtest(){
				System.out.println("I am in test.");
			}
		}

		/** GENERIC ARRAY CREATION OF TEST */	
		public QuestionArray(){
			// a = (T[]) new Object[10];
			// a = (test[]) new Object[10];
		}
		public void methodC(){
			System.out.println("I am in class C.");
		}

		// public void add(T x){
		// 	for(int i = 0; i < a.length; i++){
		// 		a[i] = new test(x);
		// 	}
		// }

		public static void main(String[] args) {
			QuestionArray<Integer> Q = new QuestionArray<>();

		}
	}