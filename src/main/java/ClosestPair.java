import java.util.*;

public class ClosestPair {
    private List<Point> points;

    ClosestPair(ArrayList<Point> points) {
        this.points = points;
    }

    public Result getMinDistPair() {
        points.sort(Comparator.comparing(p -> p.getAxes()[0]));
        return getMinDistPair(points);
    }

    private Result getMinDistPair(List<Point> points) {
        int length = points.size();
        switch (length) {
            case 1:
                return new Result(new Point(), new Point(), Double.MAX_VALUE);
            case 2:
                return new Result(points.get(0), points.get(1)) {
                };
            default:
                List<Point> lower = points.subList(0, length / 2);
                List<Point> upper = points.subList(length / 2, length);
                Result resultLeft = getMinDistPair(lower);
                Result resultRight = getMinDistPair(upper);
                if (resultLeft.getDelta() < resultRight.getDelta()) {
                    return resultLeft;
                } else
                    return resultRight;
        }
    }
}
