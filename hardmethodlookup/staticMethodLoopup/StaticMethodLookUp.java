public class StaticMethodLookUp{

	public static class A{

		public static void methodA(A x){
			System.out.println("In class A.");
		}
		public static void methodC(C x){
			System.out.println("In class A.");
		}
		public static void methodB(A x){
			System.out.println("In class A.");
		}
		public static void methodC(B x){
			System.out.println("In class A.");
		}
	}

	public static class B extends A{

		public static void methodB(C x){
			System.out.println("In class B.");
		}

		public static void methodA(A x){
			System.out.println("In class B, taking parameter A type x");
		}

		public static void methodB(B x){
			System.out.println("In class B, taking parameter B type x");
		}
	}

	public static class C extends A{

		public static void methodC(){
			System.out.println("In class B.");
		}

		public static void methodC(A x){
			System.out.println("In class B, taking parameter A type x");
		}

		public static void methodB(B x){
			System.out.println("In class B, taking parameter B type x");
		}

		public static void methodA(B x){
			System.out.println("In class B, taking parameter B type x");
		}
	}

	public static void main(String[] args) {
		A aa = new A();
		A ab = new B();
		A ac = new C();
		aa.methodA((A) C);
		ab.methodB(B);
		aa.methodA(B);
	}
}