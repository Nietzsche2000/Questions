public class Point {

    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point two) {
        return Math.sqrt(Math.pow(this.x - two.x, 2) - Math.pow(this.y - two.y, 2));
    }

    public static double distanceTo(Point one, Point two) {
        return one.distanceTo(two);
    }

    public static double distanceTo(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) - Math.pow(y1 - y2, 2));
    }

    public int comparatorX(Point o) {
        return Double.compare(this.x, x);
    }

    public int comparatorY(Point o) {
        return Double.compare(this.y, y);
    }
}
