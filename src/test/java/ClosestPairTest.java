import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

public class ClosestPairTest {
    @Test
    public void listContainsSamePointsFindThemAsResult() {
        Point p1 = new Point(1, new double[]{100, 100});
        Point p2 = new Point(2, new double[]{100, 100});
        ClosestPair closestPair = new ClosestPair(Arrays.asList(p1, p2));
        Result result = new Result(p1, p2);
        Assert.assertEquals(closestPair.getMinDistPair(), result);
    }

    @Test
    public void findSpecificResult() {
        Point p1 = new Point(1, new double[]{50, 60});
        Point p2 = new Point(2, new double[]{100, 100});
        Point p3 = new Point(2, new double[]{500, 100});
        Point p4 = new Point(2, new double[]{100, 850});
        Point p5 = new Point(2, new double[]{1000, 100});
        ClosestPair closestPair = new ClosestPair(Arrays.asList(p1, p2, p3, p4, p5));
        Result result = new Result(p1, p2);
        Assert.assertEquals(closestPair.getMinDistPair(), result);
    }
}
