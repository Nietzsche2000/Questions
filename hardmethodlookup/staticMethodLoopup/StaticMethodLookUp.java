public class StaticMethodLookUp{

	public static class A{

		public static void methodA(A x){
			System.out.println("In class A of input type A.");
		}
		public static void methodA(C x){
			System.out.println("In class A of input type C");
		}
		public static void methodB(A x){
			System.out.println("In class A of input type A.");
		}
		public static void methodC(B x){
			System.out.println("In class A of input type B.");
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

		public static void methodA(A x){
			System.out.println("In class C of input type A.");
		}
	}

	public static void main(String[] args) {
		A aa = new A();
		A ab = new B();
		A ac = new C();
		A aac = (C) new A();
		// aa.methodA((A) ac);
		// ac.methodA((A) ac);
		aac.methodA(aac);
		// ab.methodB(ab);
		// aa.methodA(ab);
	}
}