package ru.academits.java.JaroslavZuban.shape;

import java.util.Objects;

public class Square implements Shape{
    private double length;

    public Square(double lengthSquare){
        this.length=lengthSquare;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public double getArea() {
        return length*length;
    }

    @Override
    public double getPerimeter() {
        return 4*length;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + length +
                '}';
    }
}
