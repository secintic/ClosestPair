import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Point p1, p2;
    private double delta;

    Result(Point p1, Point p2) {
        this(p1, p2, p1.distanceTo(p2));
    }

    @Override
    public String toString() {
        return String.valueOf(p1) + '\n' + String.valueOf(p2);
    }
}