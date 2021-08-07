package ru.academits.java.JaroslavZuban.list;

import java.util.Stack;

public class TestList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> name=new SinglyLinkedList<>();
        ListItem<Integer> knot4=new ListItem<>((Integer) 4);
        ListItem<Integer> knot3=new ListItem<>((Integer) 3);
        ListItem<Integer> knot5=new ListItem<>((Integer) 5);
        ListItem<Integer> knot11=new ListItem<>((Integer) 11);


        name.insertElementBeginning(knot4);
        name.insertElementBeginning(knot3);
        name.insertElementBeginning(knot5);
        name.insertElementBeginning(knot11);
        name.print();


        SinglyLinkedList<Integer> name2=new SinglyLinkedList<>();
        SinglyLinkedList<Integer> name1=new SinglyLinkedList<>();
        name1.copy(name2);
        name1.print();

    }
}
