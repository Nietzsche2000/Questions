public class SuperSub {

    static int x = 10;

    public static class SuperClass{


        public SuperClass(){

        }

        public void method1(){
            System.out.println("I am a method of super class.");
        }

        public void method(){
            System.out.println("I am a method of super class.");
            String y = "I am in method of class SuperClass";
//            this.method1();
//            method1();
//            System.out.println(this.x);
            class A {
                int r = 10000000;
                void method(){
                    System.out.println(this.r);
                    System.out.println(y);
                    System.out.println(x);
                }
            }

            A a = new A();
            a.method();
            method(this);
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

        public void method(SuperClass a){
            System.out.println("I am in method of super class which takes in Subclass. ");
        }

        @Override
        public void method1(){
            System.out.println("I am a method of sub class.");
//            System.out.println(super.x);
            method();
        }
    }

    public static void main(String[] args) {
        SubClass SC = new SubClass();
        SC.method();
    }
}
