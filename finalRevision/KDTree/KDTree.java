public class KDTree {

    private class Node {
        Point point;
        Node left;
        Node right;

        public Node(Point point) {
            this.point = point;
        }

        public double distanceTo(Node o) {
            return Point.distanceTo(this.point, o.point);
        }
    }

    private Node root;

    public KDTree() {
        
    }

}