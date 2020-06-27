public class BigFish extends Object {

    public int weight;
    public String color;
    public String name;
    public static boolean likesFood = true;
    public boolean isTiny;
    public static String scales = "Dull";

    public BigFish() {
        super();
        this.weight = 100;
        this.color = "black";
        this.name = "Billy";
        this.isTiny = true;
    }

    public BigFish(int weight, String color, String name) {
        super();
        this.weight = weight;
        this.color = color;
        this.name = name;
    }

    public void swimFast() {
        if (BigFish.likesFood) {
            System.out.println("I am " + this.color);
        }
    }

    public void gainWeight(BigFish theBigOne) {
        this.weight += 111111111;
        if (true) {
            if (true) {
                String color = "rainbow";
            }
        }
        if (true) {
            String color = "gold";
        }
        if (true) {
            System.out.println(color);
            String color = "pink";
            System.out.println(color);
            System.out.println(this.color);
        }
        int x = 0;
        while (x == 0) {
            String color = "void";
            x = 1;
        }
        //String color = "colorless";
        System.out.println(color);
        System.out.println("I did it! I am " + this.color + ".....");
        System.out.println(color);
        System.out.println(this.color);
    }

    public void tinyMethod() {
        this.isTiny = false;
    }

    public static void main(String[] args) {
        BigFish newFish = new BigFish();
        newFish.swimFast();
    }
}