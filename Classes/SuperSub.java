public class SuperSub {

    public static class SuperClass{
        int x = 10;

        public SuperClass(){

        }

        public void method(){
            System.out.println("I am a method of super class.");
            System.out.println(this.x);
        }

        public void method(SuperClass a){
            System.out.println("I am in method of super class which takes in superclass. ");
        }
    }

    public static class SubClass extends SuperClass{
        int x = 100;
        public SubClass(){
            super();
        }

        public void method(SubClass a){
            System.out.println("I am in method of super class which takes in superclass. ");
        }

        public void method(){
            System.out.println("I am a method of sub class.");
            System.out.println(super.x);
            method();
        }
    }

    public static void main(String[] args) {
        SubClass SC = new SubClass();
        SC.method();
    }
}
