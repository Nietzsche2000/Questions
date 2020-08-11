import org.junit.Test;

import static org.junit.Assert.*;

public class KDTreeTest {

    @Test
    public void nearest() {
        Point[] points = new Point[]{new Point(5, 6), new Point(4, 9), new Point(2, 2),
                new Point(1, 5), new Point(7, 3), new Point(8, 7), new Point(9, 1)};
        KDTree t = new KDTree(points);
    }
}