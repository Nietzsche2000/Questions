
@FunctionalInterface
public interface InterCheck {

    public static void method1() {
        System.out.println("hello");
    }

    public int a(int x);

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();
}
