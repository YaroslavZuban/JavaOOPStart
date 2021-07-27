package ru.academits.java.JaroslavZuban.matrix;

import ru.academit.java.JaroslavZuban.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    private double sum=0;

    public Matrix(int n, int m) {
        double[][] matrixD = new double[n][m];
        matrix = new Vector[matrixD.length];

        for (int i = 0; i < matrixD.length; i++) {
            this.matrix[i] = new Vector(m);

            for (int j = 0; j < matrixD[i].length; j++) {
                this.matrix[i].setComponent(j, 0);
            }
        }
    }


    public Matrix(Matrix matrix1) {
        this.matrix = new Vector[matrix1.matrixSizeColumn()];

        for (int i = 0; i < matrix1.matrixSizeColumn(); i++) {
            this.matrix[i] = new Vector(matrix1.getVectorString(i));
        }
    }

    public Matrix(double[][] array) {
        this.matrix = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            this.matrix[i] = new Vector(array[i].length);

            for (int j = 0; j < array[i].length; j++) {
                this.matrix[i].setComponent(j, array[i][j]);
            }
        }

    }

    public Matrix(Vector[] vector) {
        this.matrix = new Vector[vector.length];

        for (int i = 0; i < vector.length; i++) {
            this.matrix[i] = new Vector(vector[i].getSize());

            for (int j = 0; j < vector[i].getSize(); j++) {
                this.matrix[i].setComponent(j, vector[i].getComponent(j));
            }
        }
    }

    public int matrixSizeColumn() {//получения размеров столбца
        return this.matrix.length;
    }

    public int matrixSizeString() {
        return this.matrix[0].getSize();
    }

    public Vector getVectorString(int index) throws IllegalArgumentException {//получение вектора строки по индексу
        if (index >= this.matrix.length) {
            throw new IllegalArgumentException("Вектора-строки нет с таким номером.");
        }

        Vector vector = new Vector(this.matrix[index].getSize());

        for (int i = 0; i < this.matrix[index].getSize(); i++) {
            vector.setComponent(i, this.matrix[index].getComponent(i));
        }

        return vector;

    }

    public void setVectorString(int index, Vector vector) throws IllegalArgumentException {//смена вектора строки по индексу
        if (index >= this.matrix.length) {
            throw new IllegalArgumentException("Вектора-строки нет с таким номером.");
        }

        if (vector.getSize() >= this.matrix[index].getSize()) {
            for (int i = 0; i < this.matrix[index].getSize(); i++) {
                this.matrix[index].setComponent(i, vector.getComponent(i));
            }
        } else {
            for (int i = 0; i < vector.getSize(); i++) {
                this.matrix[index].setComponent(i, vector.getComponent(i));
            }
        }
    }

    private void setVectorColumn(int index, Vector vector) throws IllegalArgumentException {//смена вектора столбца по индексу
        if (index >= this.matrix[0].getSize()) {
            throw new IllegalArgumentException("Вектора-столбца нет с таким номером.");
        }

        if (vector.getSize() >= this.matrix.length) {
            for (int i = 0; i < this.matrix.length; i++) {
                this.matrix[index].setComponent(i, vector.getComponent(i));
            }
        } else {
            for (int i = 0; i < vector.getSize(); i++) {
                this.matrix[index].setComponent(i, vector.getComponent(i));
            }
        }
    }

    public Vector getVectorColumn(int index) throws IllegalArgumentException {//получения вектора столбца по индексу
        if (index >= this.matrix[0].getSize()) {
            throw new IllegalArgumentException("Вектора-столбца нет с таким номером.");
        }

        Vector vector = new Vector(this.matrix.length);

        for (int i = 0; i < this.matrix.length; i++) {
            vector.setComponent(i, this.matrix[i].getComponent(index));
        }

        return vector;
    }

    public void transposeMatrix() {//транспонирование матрицы
        Vector[] vector = new Vector[this.matrix.length];

        if (this.matrix[0].getSize() == this.matrix.length) {
            for (int i = 0; i < this.matrix[0].getSize(); i++) {
                vector[i] = new Vector(this.matrix[i].getSize());

                for (int j = 0; j < this.matrix[0].getSize(); j++) {
                    vector[i].setComponent(j, this.matrix[j].getComponent(i));
                }
            }
        } else {
            for (int i = 0; i < this.matrix[0].getSize(); i++) {
                vector[i] = new Vector(this.matrix[i].getSize());

                for (int j = 0; j < this.matrix.length; j++) {
                    vector[i].setComponent(j, this.matrix[j].getComponent(i));
                }
            }
        }
        this.matrix = vector;
    }

    public void scalarMultiplication(double scalar) {//умножение матрицы на скаляр
        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i].scalarMultiplication(scalar);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {
        return "matrix=" + Arrays.toString(matrix);
    }

    public double determinantMatrix() throws IllegalAccessError {//поиск определителя матрицы
        if (this.matrix.length != this.matrix[0].getSize() || this.matrix.length == 0) {
            throw new IllegalAccessError("Извините матрицы не является квадратной!");
        }

        if (this.matrix.length == 1) {
            return this.matrix[0].getComponent(0);
        }

        if (this.matrix.length == 2) {
            return this.matrix[0].getComponent(0) * this.matrix[1].getComponent(1) -
                    this.matrix[0].getComponent(1) * this.matrix[1].getComponent(0);
        }

        getReduction(matrix,1);
        return sum;
    }

    private void getReduction(Vector[] subMinor, double elemParentMinor) {
        if (subMinor.length > 1){
            Vector[] tmpMinor = new Vector[subMinor.length - 1];

            for (int i = 0; i < tmpMinor.length; i++) {
                tmpMinor[i] = new Vector(subMinor[0].getSize() - 1);
            }

            for (int c = 0; c < subMinor[0].getSize(); c++) {
                for (int i = 1; i < subMinor.length; i++) {
                    for (int j = 0; j < subMinor[0].getSize(); j++) {
                        if (j < c) {
                            tmpMinor[i - 1].setComponent(j, subMinor[i].getComponent(j));
                        } else if (j > c) {
                            tmpMinor[i - 1].setComponent(j - 1, subMinor[i].getComponent(j));
                        }
                    }
                }

                double determinant = Math.pow(-1, c + 2) * subMinor[0].getComponent(c) * elemParentMinor;
                getReduction(tmpMinor, determinant);
            }
        }else{
            this.sum+= elemParentMinor * subMinor[0].getComponent(0);
        }
    }

    public void addMatrix(Matrix matrix1) throws IllegalArgumentException {//сложение матриц
        if (this.matrix.length != matrix1.matrixSizeColumn() ||
                this.matrix[0].getSize() != matrix1.matrixSizeString()) {
            throw new IllegalArgumentException("Извините, но матрицы разной размерности!");
        }

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i].add(matrix1.getVectorString(i));
        }
    }

    public Matrix multiplicationVector(Vector vector) throws IllegalArgumentException {//умножение матрицы на вектор
        if (this.matrix.length != vector.getSize()) {
            throw new IllegalArgumentException("Извините, число столбцов в матрице должно совпадать с числом строк.");
        }

        Vector[] vector1 = {new Vector(vector.getSize())};
        for (int i = 0; i < this.matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < this.matrix[0].getSize(); j++) {
                sum += this.matrix[i].getComponent(j) * vector.getComponent(j);
            }

            vector1[0].setComponent(i, sum);
        }

        Matrix m = new Matrix(vector1);
        return m;
    }

    public void subtractionMatrix(Matrix matrix1) throws IllegalArgumentException {//вычитание матриц
        if (this.matrix.length != matrix1.matrixSizeColumn() ||
                this.matrix[0].getSize() != matrix1.matrixSizeString()) {
            throw new IllegalArgumentException("Извините, но матрицы разной размерности!");
        }

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i].subtraction(matrix1.getVectorString(i));
        }
    }

    static Matrix multiplicationMatrix(Matrix matrix1,Matrix matrix2)throws Exception{
        if(matrix1.matrixSizeColumn()!=matrix2.matrixSizeString()){
            throw new Exception("Извините матрицы разным размеров.");
        }

        Vector[] vector=new Vector[matrix1.matrixSizeString()];

        for(int i=0;i< vector.length;i++){
            vector[i]=new Vector(matrix2.matrixSizeColumn());

            for(int j=0;j<vector[i].getSize();j++){
                double sum=0;
                Vector vector1=matrix1.getVectorString(i);
                Vector vector2=matrix2.getVectorColumn(i);

                for (int k=0;k<vector.length;k++){
                    sum+=vector1.getComponent(k)*vector2.getComponent(j);
                }

                vector[i].setComponent(j,sum);
            }
        }

        return new Matrix(vector);
    }

    static Matrix subtractionMatrix(Matrix matrix1,Matrix matrix2)throws Exception{
        if(matrix1.matrixSizeColumn()!=matrix2.matrixSizeColumn()||matrix1.matrixSizeString()!=matrix2.matrixSizeString()){
            throw new Exception("Извините матрицы разным размеров.");
        }

        Vector[] vector=new Vector[matrix1.matrixSizeString()];

        for(int i=0;i< vector.length;i++){
            vector[i]=new Vector(matrix1.matrixSizeColumn());
            vector[i]=Vector.subtractionVector(matrix1.getVectorString(i),matrix2.getVectorString(i));
        }


        return new Matrix(vector);
    }

    static Matrix addMatrix(Matrix matrix1,Matrix matrix2)throws Exception{
        if(matrix1.matrixSizeColumn()!=matrix2.matrixSizeColumn()||matrix1.matrixSizeString()!=matrix2.matrixSizeString()){
            throw new Exception("Извините матрицы разным размеров.");
        }

        Vector[] vector=new Vector[matrix1.matrixSizeString()];

        for(int i=0;i< vector.length;i++){
            vector[i]=new Vector(matrix1.matrixSizeColumn());
            vector[i]=Vector.addVector(matrix1.getVectorString(i),matrix2.getVectorString(i));
        }

        return new Matrix(vector);

    }
}
