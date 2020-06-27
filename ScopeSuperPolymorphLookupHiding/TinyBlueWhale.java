public class TinyBlueWhale extends BlueWhale {
    public String isTiny;
    public static String scales = "Sharp";

    public TinyBlueWhale() {
        super();
        this.isTiny = "a";
        super.scales = "Narrow";
        this.scales = "Massive";
        super.isTiny = false;
    }

    public boolean getIsTiny() {
        System.out.println(this.isTiny);
        return super.isTiny;
    }

    public static void main(String[] args) {
        TinyBlueWhale whale1 = new TinyBlueWhale();
        System.out.println(whale1.getIsTiny());
    }
}