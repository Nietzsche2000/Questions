public class Fields{

	public static class A{

	/** Member variables */
	// public static String x = "A class, static field";
	// public String y = "Instance field y in A";
	public static int x;
	public int y;

	}


	public static class B extends A{

	/** Member variables */
	// public static String x = "B class, static field";
	// public String y = "Instance field y in B";
	public static int x = 10;
	public int y = 20;

	}

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A ab = new B();
		// System.out.println(a.y);
		System.out.println(b.y);
		System.out.println(ab.y);
	}


}