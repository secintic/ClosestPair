import java.util.List;


public class Application {
    public static void main(String[] args) {
        String inputFilename = "sample_input_10_100.tsv";
        String outputFilename = "output.tsv";
        List<Point> points = FileOperations.readPointsFromFile(inputFilename);
        ClosestPair closestPair = new ClosestPair(points);
        FileOperations.writeResultsToFile(outputFilename, closestPair.getMinDistPair());
    }
}
