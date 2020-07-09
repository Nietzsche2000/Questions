public class Sub extends Super {

  // when the sub class does not have a constructor it by default has a zero arguement constructor that calls the super class
  // construtor like: super(); thus if the super class does not have a zero-arguement construtor it will fail
  // like below:
  
  // public Sub() {
  //   super();
  // }


  public static void main(String[] args) {
    System.out.println("sub");
  }

}
