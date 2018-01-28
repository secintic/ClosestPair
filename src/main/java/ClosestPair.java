import java.io.File;
import java.io.IOException;
import java.util.*;

public class ClosestPair {
    private Point best1, best2;
    private double bestDistance = Double.POSITIVE_INFINITY;

    private ClosestPair(Point[] points) {
        int n = points.length;
        if (n <= 1) return;

        Point[] pointsByX = new Point[n];
        System.arraycopy(points, 0, pointsByX, 0, n);
        Arrays.sort(pointsByX, Comparator.comparing(Point::getXAxis));

        Point[] pointsByY = new Point[n];
        System.arraycopy(pointsByX, 0, pointsByY, 0, n);
        closest(pointsByX, pointsByY, new Point[n], 0, n - 1);
    }

    private double closest(Point[] pointsByX, Point[] pointsByY, Point[] aux, int lowerBound, int higherBound) {
        if (higherBound <= lowerBound) return Double.POSITIVE_INFINITY;

        int middleOfTheArray = lowerBound + (higherBound - lowerBound) / 2;
        Point median = pointsByX[middleOfTheArray];

        double delta1 = closest(pointsByX, pointsByY, aux, lowerBound, middleOfTheArray);
        double delta2 = closest(pointsByX, pointsByY, aux, middleOfTheArray + 1, higherBound);
        double delta = Math.min(delta1, delta2);

        merge(pointsByY, aux, lowerBound, middleOfTheArray, higherBound);
        int m = 0;
        for (int i = lowerBound; i <= higherBound; i++) {
            if (Math.abs(pointsByY[i].getXAxis() - median.getXAxis()) < delta)
                aux[m++] = pointsByY[i];
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; (j < m) && (aux[j].getYAxis() - aux[i].getYAxis() < delta); j++) {
                double distance = aux[i].distanceTo(aux[j]);
                if (distance < delta) {
                    delta = distance;
                    if (distance < bestDistance) {
                        setBestResult(aux[i], aux[j], delta);
                    }
                }
            }
        }
        return delta;
    }

    private void setBestResult(Point best1, Point best2, double bestDistance) {
        this.bestDistance = bestDistance;
        this.best1 = best1;
        this.best2 = best2;
    }

    private Point either() {
        return best1;
    }

    private Point other() {
        return best2;
    }


    private void merge(Point[] a, Point[] aux, int lowerBound, int middleOfTheArray, int higherBound) {
        System.arraycopy(a, lowerBound, aux, lowerBound, higherBound + 1 - lowerBound);
        int i = lowerBound, j = middleOfTheArray + 1;
        for (int k = lowerBound; k <= higherBound; k++) {
            if (i > middleOfTheArray) a[k] = aux[j++];
            else if (j > higherBound) a[k] = aux[i++];
            else if ((aux[j].compareTo(aux[i])) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Point> pointArray = new ArrayList<>();
        File file = new File("sample_input_2_8.tsv");
        Scanner scanner = new Scanner(file);
        int counter = 0;
        while (scanner.hasNext()) {
            pointArray.add(new Point(++counter, scanner.nextDouble(), scanner.nextDouble()));
        }
        scanner.close();

        Point[] points = pointArray.toArray(new Point[pointArray.size()]);
        ClosestPair closest = new ClosestPair(points);
        System.out.println("from " + closest.either() + " to " + closest.other());
    }

}
