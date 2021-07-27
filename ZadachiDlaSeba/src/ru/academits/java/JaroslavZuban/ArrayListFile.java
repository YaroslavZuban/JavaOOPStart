package ru.academits.java.JaroslavZuban;

import java.io.*;
import java.util.ArrayList;

public class ArrayListFile {
    public static void main(String[] args) {
        File fileLine=new File("C:\\Users\\ben70\\IdeaProjects\\JavaOOPStart\\ZadachiDlaSeba\\src\\ru\\academits\\java\\JaroslavZuban\\StringFile.txt");

        try (FileReader fileReader=new FileReader(fileLine);
             BufferedReader bufferedReader=new BufferedReader(fileReader)){

            ArrayList<String> file=new ArrayList<String>();
            String line=bufferedReader.readLine();

            while (line!=null){
                file.add((String) line);
                line=bufferedReader.readLine();
            }

            System.out.println(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
