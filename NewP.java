public class NewP {

  // public static NewP dog = new NewP();
  public NewP dog = new NewP();

  public NewP() {
    super();
    // NewP.dog = new NewP();
    // this.dog = new NewP();
  }

  public void test() {
    //int dog = 10;
    dog.test1();

  }

  public void test1() {
    System.out.println(10);
  }

  public static void main(String[] args) {
    NewP tt = new NewP();
    tt.test();
  }

}
