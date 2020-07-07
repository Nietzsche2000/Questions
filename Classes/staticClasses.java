//public class staticClasses{
//
//	public static class A{
//		public class Test{
//
//			public void methodA(){
//				System.out.println("I am in methodA of class Test in class A.");
//			}
//		}
//	}
//
//	public static class B extends A{
//		// public static class Test{
//
//		// }
//		Test k;
//		public B(){
//			super();
//			k = new Test();
//		}
//
//		public void methodB(){
//			// Test k;
//			// k = new Test();
//			k.methodA();
//			System.out.println("I am in methodB of class B which extends A.");
//		}
//	}
//
//	public static class C extends B{
//		/** Is this Overriding or Shadowing or class hiding? */
//		/** Is this the consequence of lexical scoping? */
//		public class Test{
//
//		}
//
//		Test k;
//		public C(){
//			super();
//			k = new Test();
//		}
//
//		public void methodC(){
//			// Test k;
//			// k = new Test();
//			k.methodA();
//			System.out.println("I am in methodC of class C which extends B.");
//		}
//	}
//
//	public static void main(String[] args){
//		// int i;
//  //       for (i = 0; i < 10; i++)
//  //           System.out.print(i + " ");
//  //       for (i = 0; i < 10; i++)
//  //           System.out.print(i + " ");
//  //       System.out.println();
//		B b = new B();
//		b.methodB();
//    }
//}