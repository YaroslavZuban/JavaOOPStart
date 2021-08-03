package ru.academit.java.JaroslavZuban.vector;

import java.util.Arrays;

public class Vector {
    private double[] array;

    public Vector(int n) throws IllegalArgumentException {//заполнения вектора пустыми ячейками точнее нулями
        if (n <= 0) {
            throw new IllegalArgumentException("Извините, но размерность вектора равна нулю или меньше нуля!");
        }

        this.array = new double[n];

        Arrays.fill(this.array, 0);
    }

    public Vector(Vector vector) {
        this.array = new double[vector.getSize()];

        for (int i = 0; i < array.length; i++) {
            this.array[i] = vector.getComponent(i);
        }
    }


    public Vector(double[] mas) {//копирование значения из вектора
        this.array = new double[mas.length];

        for (int i = 0; i < array.length; i++) {
            this.array[i] = mas[i];
        }
    }

    public Vector(int n, double[] mas) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Извините, но размерность вектора равна нулю или меньше нуля!");
        }

        if (n > mas.length) {
            this.array = new double[n];

            for (int i = 0; i < n; i++) {
                if (i < mas.length) {
                    this.array[i] = mas[i];
                } else {
                    this.array[i] = 0;
                }
            }
        }
    }

    public int getSize() {
        return this.array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

    public double getComponent(int index) {
        return this.array[index];
    }

    public void setComponent(int index, double number) {
        if (index >= this.array.length) {
            int length = this.array.length;
            Arrays.copyOf(this.array, index + 1);
            int difference = index - length;

            for (int i = length; i < this.array.length; i++) {
                if (i == index) {
                    array[i] = number;
                } else {
                    array[i] = 0;
                }
            }
        } else {
            this.array[index] = number;
        }

    }

    public void add(Vector vector) {
        int max = Math.max(getSize(), vector.getSize());

        if (max == getSize()) {
            for (int i = 0; i < max; i++) {
                if (i < vector.getSize()) {
                    this.array[i] += vector.getComponent(i);
                }
            }
        } else {
            double[] newArray = new double[max];

            for (int i = 0; i < max; i++) {
                if (i >= getSize()) {
                    newArray[i] = vector.getComponent(i);
                } else {
                    newArray[i] = this.array[i] + vector.getComponent(i);
                }
            }

            this.array = Arrays.copyOf(newArray, max);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(array, vector.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public void subtraction(Vector vector) {
        int max = Math.max(getSize(), vector.getSize());

        if (max == getSize()) {
            for (int i = 0; i < max; i++) {
                if (i < vector.getSize()) {
                    this.array[i] -= vector.getComponent(i);
                }
            }
        } else {
            double[] newArray = new double[max];

            for (int i = 0; i < max; i++) {
                if (i >= getSize()) {
                    newArray[i] = -vector.getComponent(i);
                } else {
                    newArray[i] = this.array[i] - vector.getComponent(i);
                }
            }

            this.array = Arrays.copyOf(newArray, max);
        }
    }

    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] *= scalar;
        }
    }

    public void reversal() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] *= -1;
        }
    }

    public static Vector addVector(Vector vector1, Vector vector2) {
        int max = Math.max(vector1.getSize(), vector2.getSize());
        Vector newVector;

        if (max == vector1.getSize()) {
            for (int i = 0; i < vector1.getSize(); i++) {
                vector1.setComponent(i, vector1.getComponent(i) + vector2.getComponent(i));
            }

            return vector1;
        }

        newVector = new Vector(vector2);
        newVector.add(vector1);

        return newVector;
    }

    public static Vector subtractionVector(Vector vector1, Vector vector2) {
        int max = Math.max(vector1.getSize(), vector2.getSize());
        Vector newVector;

        if (max == vector1.getSize()) {
            for (int i = 0; i < vector1.getSize(); i++) {
                vector1.setComponent(i, vector1.getComponent(i) - vector2.getComponent(i));
            }

            return vector1;
        }

        newVector = new Vector(vector2);
        newVector.subtraction(vector1);

        return newVector;
    }

    public static double scalarProductVector(Vector vector1, Vector vector2) {
        int max = Math.max(vector1.getSize(), vector2.getSize());

        double scalarSum = 0;
        if (max == vector1.getSize()) {
            for (int i = 0; i < vector1.getSize(); i++) {
                if (i < vector2.getSize()) {
                    scalarSum += vector1.getComponent(i) * vector2.getComponent(i);
                }
            }
        } else {
            for (int i = 0; i < vector2.getSize(); i++) {
                if (i < vector1.getSize()) {
                    scalarSum += vector1.getComponent(i) * vector2.getComponent(i);
                }
            }
        }

        return scalarSum;
    }


}
