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


  public static boolean var1;
  public static byte var2;
  public static short var3;
  public static int var4;
  public static long var5;
  public static float var6;
  public static double var7;
  public static char var8;

  public AllPrimitives() {
    super();
  }


  public static void main(String[] args) {

    int var0 = 7;
    System.out.println(var0);
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

    System.out.println();
    System.out.println();


    AllPrimitives instance = new AllPrimitives();
    System.out.println(instance.unknown);


    System.out.println();
    System.out.println();




    AllPrimitives instance2 = new AllPrimitives();
    System.out.println(instance2);
    System.out.println();
    System.out.println();
    System.out.println(var1);
    System.out.println(var2);
    System.out.println(var3);
    System.out.println(var4);
    System.out.println(var5);
    System.out.println(var6);
    System.out.println(var7);
    System.out.println(var8);

  }

}
