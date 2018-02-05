import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FileOperations {
    static List<Point> readPointsFromFile(String fileName) {
        List<Point> points = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            AtomicInteger index = new AtomicInteger(0);
            reader.lines().map(line -> Stream.of(line.split("\t")))
                    .map(s -> s.mapToDouble(Double::valueOf))
                    .map(DoubleStream::toArray)
                    .forEachOrdered(coordinates -> points.add(
                            new Point(index.incrementAndGet(), coordinates)));
            return points;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    static void writeResultsToFile(String fileName, Result result) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
