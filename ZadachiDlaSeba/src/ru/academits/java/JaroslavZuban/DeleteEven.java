package ru.academits.java.JaroslavZuban;

import java.util.ArrayList;

public class DeleteEven {
    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            number.add(i);
        }

        System.out.println(number);

        int i = 0;

        while (i < number.size() && number.get(i) % 2 == 0) {
            number.remove(i);`
            i++;
        }

        System.out.println(number);
    }
}
