package com.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Point {
    private int index;
    private double[] axes;


    double distanceTo(Point p) {
        double totalDistanceSquare = IntStream.range(0, axes.length)
                .mapToDouble(i -> this.axes[i] - p.axes[i])
                .map(dif -> dif * dif)
                .reduce(0, Double::sum);
        return Math.sqrt(totalDistanceSquare);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(index).append(":");
        for (double axis : axes)
            stringBuilder.append(axis).append('\t');
        return stringBuilder.toString();
    }
}
