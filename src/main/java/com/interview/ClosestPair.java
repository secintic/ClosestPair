package com.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClosestPair {
    private List<Point> points;
    private int numberOfDimensions;
    private Result result;

    ClosestPair(List<Point> points) {
        this.points = points;
        this.numberOfDimensions = points.get(0).getAxes().length;
        this.result = new Result();
    }

    public Result getMinDistPair() {
        AtomicInteger dimensionCounter = new AtomicInteger(-1);
        while (dimensionCounter.incrementAndGet() < numberOfDimensions) {
            points.sort(Comparator.comparing(p -> p.getAxes()[dimensionCounter.get()]));
            if (getMinDistPair(points).getDelta() < result.getDelta())
                result = getMinDistPair(points);
        }
        return result;
    }

    private Result getMinDistPair(List<Point> points) {
        Result tempResult;
        int length = points.size();
        switch (length) {
            case 1:
                return new Result(new Point(), new Point(), Double.MAX_VALUE);
            case 2:
                return new Result(points.get(0), points.get(1));
            default:
                tempResult = divideAlgorithm(points, length, length / 2);
                tempResult = checkMedianCloserPoints(points, tempResult, length / 2);
                return tempResult;
        }
    }

    private Result checkMedianCloserPoints(List<Point> points, Result tempResult, int median) {
        List<Point> medianCloserPointList = createMedianCloserPointsList(points, tempResult, median);
        for (int i = 0; i < medianCloserPointList.size(); i++) {
            for (int j = i + 1; j < medianCloserPointList.size(); j++) {
                if (medianCloserPointList.get(i).distanceTo(medianCloserPointList.get(j)) < tempResult.getDelta())
                    tempResult = new Result(medianCloserPointList.get(i), medianCloserPointList.get(j));
            }
        }
        return tempResult;
    }

    private List<Point> createMedianCloserPointsList(List<Point> points, Result tempResult, int median) {
        List<Point> medianCloserPointList = new ArrayList<>();
        for (Point point : points) {
            if (point.distanceTo(points.get(median)) < tempResult.getDelta())
                medianCloserPointList.add(point);
        }
        return medianCloserPointList;
    }

    private Result divideAlgorithm(List<Point> points, int length, int median) {
        List<Point> lower = points.subList(0, median);
        List<Point> upper = points.subList(median + 1, length);
        Result resultLeft = getMinDistPair(lower);
        Result resultRight = getMinDistPair(upper);
        if (resultLeft.getDelta() < resultRight.getDelta())
            return resultLeft;
        else
            return resultRight;
    }
}
