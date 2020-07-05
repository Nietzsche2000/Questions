public class MethlookupInMethLookup extends Object {

  public class A extends Object {

    public void m1(A a) {
      System.out.println("method: m1, class: A, input: A");
      this.m2(a);
    }

    public void m2(A a) {
      System.out.println("method: m2, class: A, input: A");
    }

    public void m2(B b) {
      System.out.println("method: m2, class: A, input: B");

    }

  }

  public class B extends A {

    @Override
    public void m1(A a) {
      System.out.println("method: m1, class: B, input: A");
      this.m2(a);
    }

//    @Override
//    public void m2(A a) {
//      System.out.println("method: m2, class: B, input: A");
//    }

    @Override
    public void m2(B b) {
      System.out.println("method: m2, class: B, input: B");
    }

  }

  public class C extends B {

    @Override
    public void m1(A a) {
      System.out.println("method: m1, class: C, input: A");
      this.m2(a);
    }

    @Override
    public void m2(B b) {
      System.out.println("method: m2, class: C, input: B");
    }

  }

  public static void main(String[] args) {
    MethlookupInMethLookup inst = new MethlookupInMethLookup();
    A a_a = inst.new A();
    A a_b = inst.new B();
    B b_b = inst.new B();
    B b_c = inst.new C();
    b_b.m1(b_c);
    //a_b.m1(b_c);

//    b_b.m1(a_b);
//    b_b.m1(a_a);

  }

}



