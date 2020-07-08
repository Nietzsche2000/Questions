public class InheritanceHeirarchy {

	public static class A{
		int x = 5;
	}

	public static class B extends A{
		static int x = 10;
	}

	public static class C extends B{

	}

	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.x);
	}
}