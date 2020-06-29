public class StaticMethodLookUp{

	public static class A{
		public int x = 5;

		public static void methodA(){
			System.out.println("I'm in class A, methodA-no arguments.");
		}

		public static void methodA(B x){
			System.out.println("I'm in class A, methodA-single argument of type A.");
		}
	}


	public static class B extends A{

		public static void methodB(){
			System.out.println("I'm in class B, methodB-no arguments.");
		}

		public static void methodA(A x){
			System.out.println("I'm in class B, methodA-single argument of type A.");
		}
	}

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A ab = new B();
		b.methodA(b);
	}
}