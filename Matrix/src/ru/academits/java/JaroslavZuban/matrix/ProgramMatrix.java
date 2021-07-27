package ru.academits.java.JaroslavZuban.matrix;

import ru.academit.java.JaroslavZuban.vector.Vector;

public class ProgramMatrix {
    public static void main(String[] args) {
        double[][] mas={{1,1,1}};
        double[][] array = {{1, 0,0}, {0, 2,0}, {0, 0,3}};

        Matrix matrix = new Matrix(array);
        Matrix matrix1 = new Matrix(mas);



        Matrix matrix2;
        try {
            matrix2=Matrix.multiplicationMatrix(matrix,matrix1);
            System.out.println(matrix2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

