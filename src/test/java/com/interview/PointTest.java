package com.interview;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distanceToSamePointIsZero() {
        Point p1 = new Point(1, new double[]{100, 100});
        Point p2 = new Point(2, new double[]{100, 100});
        Assert.assertEquals(p1.distanceTo(p2), 0.0, 2);
    }

    @Test
    public void distanceBetweenSpecificPointIsEqual() {
        Point p1 = new Point(1, new double[]{50, 100});
        Point p2 = new Point(2, new double[]{0, 50});
        Assert.assertEquals(p1.distanceTo(p2), 70.71, 2);
    }
}
