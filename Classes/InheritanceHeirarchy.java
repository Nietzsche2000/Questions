public class InheritanceHeirarchy {

	public static class A{
		static int x = 5;
	}

	public static class B extends A{
		int x = 55;
		// static int x = 10;
	}

	public static class C extends B{
		// static int x = 1000;

	}

	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.x);
	}
}