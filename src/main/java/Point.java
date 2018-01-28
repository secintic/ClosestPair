import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Point {
    private int index;
    private Double xAxis;
    private Double yAxis;


    double distanceTo(Point aux) {
        return Math.pow(this.getYAxis() - aux.getYAxis(), 2) + Math.pow(this.getXAxis() - aux.getXAxis(), 2);
    }

    public int compareTo(Point p) {
        return Double.compare((Math.pow(this.getYAxis(), 2) + Math.pow(this.getXAxis(), 2)), Math.pow(p.getYAxis(), 2) + Math.pow(p.getXAxis(), 2));
    }

    @Override
    public String toString() {
        return index + ":" + xAxis + "\t" + yAxis;
    }
}
