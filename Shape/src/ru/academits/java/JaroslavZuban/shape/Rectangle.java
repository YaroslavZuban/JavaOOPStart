package ru.academits.java.JaroslavZuban.shape;

import java.util.Objects;

public class Rectangle implements Shape{
    private double length;
    private double height;

    public Rectangle(double length,double height){
        this.length=length;
        this.height=height;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return length*height;
    }

    @Override
    public double getPerimeter() {
        return length*2+height*2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", height=" + height +
                '}';
    }
}
