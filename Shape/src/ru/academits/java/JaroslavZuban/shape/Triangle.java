package ru.academits.java.JaroslavZuban.shape;

import java.util.Arrays;
import java.util.Objects;

public class Triangle implements Shape {
    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

    }

    @Override
    public double getWidth() {
        double[] arrayX = {x1, x2, x3};
        Arrays.sort(arrayX);
        return arrayX[arrayX.length - 1] - arrayX[0];
    }

    @Override
    public double getHeight() {
        double[] arrayY = {y1, y2, y3};
        Arrays.sort(arrayY);
        return arrayY[arrayY.length - 1] - arrayY[0];
    }

    @Override
    public double getArea() {
        double area = 0.5 * ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));

        if (area < 0) {
            return -area;
        }

        return area;
    }

    @Override
    public double getPerimeter() {
        final double epsilon = 1.0e-10;

        if (Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) <= epsilon) {
            return 0;
        } else {
            double AB = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            double BC = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
            double CA = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
            return AB + BC + CA;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.x1, x1) == 0 &&
                Double.compare(triangle.y1, y1) == 0 &&
                Double.compare(triangle.y2, y2) == 0 &&
                Double.compare(triangle.y3, y3) == 0 &&
                Double.compare(triangle.x2, x2) == 0 &&
                Double.compare(triangle.x3, x3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3);
    }

    @Override
    public String toString() {
        return "Triangle{ (" +
                "x1=" + x1 +
                "y1=" + y1 +
                "),(x2=" + x2 +
                "y2=" + y2 +
                "),(x3=" + x3 +
                "y3=" + y3 +
                ")}";
    }
}
