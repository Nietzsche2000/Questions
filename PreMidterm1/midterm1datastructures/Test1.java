public class Test1 {

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class PointList {
        public Point p;
        public PointList next;

        public PointList(Point p, PointList next) {
            this.p = p;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        int x = 3;
//        int y = 4;
//        Point p = new Point(x, y);
//        PointList lst = new PointList(p, new PointList(p, null));
//        lst.next.next = lst.next;
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        PointList lst = new PointList(p2, null);
        lst.next = new PointList(p1, lst);
        PointList tmp = lst.next;
        int x = tmp.next.next.next.p.x;
        int y = lst.p.y;
        tmp = null;
        p1 = null;
        p2  = null;
    }
}
