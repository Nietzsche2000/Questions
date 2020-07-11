public class monishtest {


  public static class A extends monishtest {

    public A(int x) {
      super();
    }
  }

  public static class B extends A {

    public B() {
      //super();
    }
  }

  // public static void method() {
  //   int x = 1/0;
  // }

  public static void method1() {
    int[] ar = new int[-9];
    System.out.println(ar[2]);
  }

  public static void main(String[] args) {
    monishtest.method1();
  }

}
