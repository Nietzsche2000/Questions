public class Covariant{
	public static class A{
		public void methodA(){
			System.out.println("I am in A.");
		}
	}

	public static class B extends A{

		@Override
		public void methodA(){
			System.out.println("I am in B.");
		}
	}

	public static class C<T>{
		public test[] a;

		public class test{
			T item;
			// public test(T x){
			// 	item = x;
			// }

			// public void methodtest(){
			// 	System.out.println("I am in test.");
			// }
		}

		public C(){
			// a = (T[]) new Object[10];
			// a = (test[]) new Object[10];
			// a = test<?>[10];
		}
		public void methodC(){
			System.out.println("I am in class C.");
		}

		// public void add(T x){
		// 	for(int i = 0; i < a.length; i++){
		// 		a[i] = new test(x);
		// 	}
		// }
	}

	/** Main method for Covariant */
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		B[] bb = new B[10];
		for(int i = 0; i < 10; i++)
			bb[i] = new B();
		A[] aa = new A[10];
		// aa = bb;
		// for(int i = 0; i < 10; i++)
		// 	aa[i] = bb[i];
		// for(int i = 0; i < 10; i++)
		// 	aa[i].methodA();
		C<Integer> c = new C<>();
		C<Integer>[] k = new C[10];
		// for(int i = 0; i < 10; i++)
		// 	k[i] = c;
		// for(int i = 0; i < 10; i++)
		// 	k[i].methodC();
		// c.add(1);
		// for(int i = 0; i < 10; i++)
		// 	c.a[i].methodtest();




 	}
}