class Super extends Object {

  // with this method this file will compile but the Sub.java will no longer because Super.java does not have a zero-arg construtor
  public Super(int number) {
    super();
  }

  // but if I make this then now Sub.java will work
  public Super() {
    super();
  }

  public static void main(String[] args) {
    System.out.println("super");
  }

}
