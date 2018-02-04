import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IOException {

        String filename = "sample_input_10_100.tsv";
        ArrayList<Point> points = readPointsFromFile(filename);


        ClosestPair closestPair = new ClosestPair(points);
        System.out.println(closestPair.getMinDistPair());
    }

    private static ArrayList<Point> readPointsFromFile(String fileName) throws IOException {
        ArrayList<Point> points = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        AtomicInteger index = new AtomicInteger(0);
        reader.lines().map(line -> Stream.of(line.split("\t")))
                .map(s -> s.mapToDouble(Double::valueOf))
                .map(DoubleStream::toArray)
                .forEachOrdered(coordinates -> points.add(
                        new Point(index.incrementAndGet(), coordinates)));
        return points;
    }
}
