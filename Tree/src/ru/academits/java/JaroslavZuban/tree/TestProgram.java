package ru.academits.java.JaroslavZuban.tree;

public class TestProgram {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.addSheets(5);
        tree.addSheets(4);
        tree.addSheets(3);
        tree.addSheets(0);
        tree.addSheets(4);
        tree.addSheets(5);
        tree.addSheets(10);
        tree.addSheets(7);
        tree.addSheets(13);
        tree.addSheets(15);


        System.out.println(tree.getNumberSheets());
        System.out.print("Print: ");
        tree.print();

        System.out.println();
        System.out.println("Element: "+tree.searchElement(new ListItem(4)));

        tree.removeNode(new ListItem(4));
        System.out.print("Print: ");
        tree.print();
    }
}
