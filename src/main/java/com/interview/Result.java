package com.interview;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private Point p1, p2;
    private double delta;

    Result(Point p1, Point p2) {
        this(p1.getIndex() < p2.getIndex() ? p1 : p2, p1.getIndex() < p2.getIndex() ? p2 : p1, p1.distanceTo(p2));
    }

    Result() {
        this.delta = Double.MAX_VALUE;
    }

    @Override
    public String toString() {
        return String.valueOf(p1) + '\n' + String.valueOf(p2);
    }
}