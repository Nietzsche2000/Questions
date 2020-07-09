public class MonishQuestion extends Object {

  public class InnerClass extends Object {

    public int innerClass = 90;
    //public static int innerClass = 90;
    public int iClass;

    public InnerClass() {
      super();
      this.iClass = 900;
    }

  }

  public static int outerClass = 10;
  public int oClass;

  public MonishQuestion() {
    super();
    this.oClass = 100;
  }

  public static void main(String[] args) {

    MonishQuestion mm = new MonishQuestion();
    //System.out.println(mm.InnerClass.innerClass);
    //int x = mm.InnerClass.innerClass;
    System.out.println((mm.new InnerClass()).innerClass);
    //System.out.println(mm);

  }



}
