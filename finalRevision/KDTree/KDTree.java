public class KDTree {

    private class Node {
        Point point;
        Node left;
        Node right;

        public Node() {

        }

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

    public void insert(Point p) {
        root = insert(root, p, 0);
    }

    /* helper method for insert ϴ(LogN)*/
    private Node insert(Node node, Point p, int level) {
        if (node == null)
            return new Node(p);
        if (level % 2 == 0) {
            if (p.comparatorX(node.point) >= 0) {
                node.right = insert(node.right, p, level + 1);
            } else {
                node.left = insert(node.left, p, level + 1);
            }
        } else {
            if (p.comparatorY(node.point) >= 0) {
                node.right = insert(node.right, p, level + 1);
            } else {
                node.left = insert(node.left, p, level + 1);
            }
        }
        return node;
    }

    /* Nearest finder */
    public Point nearest(Point p) {
        return nearest(root, root, p, 0).point;
    }

    /* helper for nearest */
    public Node nearest(Node node, Node best, Point p, int level) {
        if (node == null)
            return best;
        if (p.distanceTo(node.point) < p.distanceTo(best.point)) {
            best = node;
        }
        Node goodSide;
        Node badSide;
        if (level % 2 == 0) {
            if (p.comparatorX(node.point) >= 0) {
                goodSide = node.right;
                badSide = node.left;
            } else {
                goodSide = node.left;
                badSide = node.right;
            }
        } else {
            if (p.comparatorY(node.point) >= 0) {
                goodSide = node.right;
                badSide = node.left;
            } else {
                goodSide = node.left;
                badSide = node.right;
            }
        }
        best = nearest(goodSide, best, p, level + 1);

    }

    /* Helper for checking if viable points present on the bad side */
    private boolean isBadSideReallyGood(Node node, Point p, Node best, int level) {
        if (level % 2 == 0) {
            return p.distanceTo()
        }
    }
}