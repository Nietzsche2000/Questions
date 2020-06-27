public class BlueWhale extends BigFish {
    public int weight;
    public String color;
    public String name;
    public static boolean likesFood = true;
    public static String scales = "None";

    public BlueWhale() {
        super();
        super.scales = "Thick";
        super.color = "blue";
        this.color = "blueish";
    }

    public BlueWhale(int weight, String color, String name) {
        super(weight, color, name);
    }

    @Override
    public void swimFast() {
        System.out.println("I am a blue whale that eats krill");
        super.swimFast(); // this will work well
        //this.swimFast(); // this will run forever
    }

    @Override
    public void gainWeight(BigFish theBigOne) {
        super.gainWeight(theBigOne);
        System.out.println(this.color + "!");
        String color = "invisible";
        System.out.println(color);
        System.out.println(this.color);
        System.out.println(super.color);
    }

    public static void main(String[] args) {
//        BlueWhale blueTheWhale = new BlueWhale();
//        blueTheWhale.swimFast();
//        BlueWhale bb = new BlueWhale(1, "green", "Que");
//        bb.swimFast();
//        BigFish bubble = (BigFish) new BlueWhale();
        BigFish fish1 = new BigFish();
        BlueWhale fish2 = new BlueWhale();
        BigFish fish3 = new BlueWhale();

        fish2.gainWeight(fish1);
    }
}