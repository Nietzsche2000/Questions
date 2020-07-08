public class Extension{

	public static class A{
		int x = 10;

		void A(){
			System.out.println("I am in class A.");
		}

		public void methodA(){

			class innerClass{
				A innerMethod(){
					A ab = new B();
					System.out.println("I am in class A");
					return ab;
				}
			}

			innerClass iC = new innerClass();
			iC.innerMethod().A();

		}

	}

	public static class B extends A{
		int x = 100;

		public void methodA(){
			class innerClass{
				A innerMethodA(){
					A a = new A();
					return a;
				}
			}

			innerClass iC = new innerClass();
			iC.innerMethodA().A();

		}
	}

	

	public static void main(String[] args) {
		A a = new B();
		a.methodA();
	}
}