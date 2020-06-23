class AllPrimitives extends Object {


  public static boolean the = true;
  static boolean dog = false;
  static byte is = 127;
  static short running = 10;
  static int down = 10000;
  static long a = 10000000000000000L;
  static float hill = 10.01f;
  static double really = 99.88998;
  static char fast = 'a';
  static char ryan = 45;
  static char bill = 89;
  static char unknown = 8989;

  public AllPrimitives() {
    super();
  }


  public static void main(String[] args) {

    int var1 = 7;
    System.out.println(var1);
    System.out.println();
    System.out.println();

    System.out.println(AllPrimitives.the);
    System.out.println(AllPrimitives.dog);
    System.out.println(AllPrimitives.is);
    System.out.println(AllPrimitives.running);
    System.out.println(AllPrimitives.down);
    System.out.println(AllPrimitives.a);
    System.out.println(AllPrimitives.hill);
    System.out.println(AllPrimitives.really);
    System.out.println(AllPrimitives.fast);
    System.out.println(AllPrimitives.ryan);
    System.out.println(bill);


    AllPrimitives instance = new AllPrimitives();
    System.out.println(instance.unknown);
  }

}
