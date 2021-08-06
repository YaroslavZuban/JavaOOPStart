package ru.academits.java.JaroslavZuban.tree;


public class Tree {
    private ListItem head;
    private int numberSheets;

    public Tree() {
        this.numberSheets = 0;
        this.head = new ListItem();
    }

    public int getNumberSheets() {
        return numberSheets;
    }

    public void addSheets(Integer element) {
        ListItem listItem = new ListItem();
        listItem.setData(element);

        if (this.head.getData() == null) {
            this.head = listItem;
            this.numberSheets++;
        } else {
            ListItem current = this.head;
            ListItem prev = null;

            while (true) {
                prev = current;
                if (element <= prev.getData()) {
                    current = current.getLeft();

                    if (current == null) {
                        prev.setLeft(listItem);
                        this.numberSheets++;
                        return;
                    }
                } else {
                    current = current.getRight();

                    if (current == null) {
                        prev.setRight(listItem);
                        this.numberSheets++;
                        return;
                    }
                }
            }
        }
    }

    public void print() {
        printTree(head);
    }

    public boolean searchElement(ListItem element) {
        return searchElementTree(element, head);
    }


    public void removeNode(ListItem element) {
        this.head = removeNodeTree(this.head, element.getData());
    }

    private ListItem removeNodeTree(ListItem element, Integer number) {
        if (element == null) {
            return null;
        }

        if (number < element.getData()) {
            element.setLeft(removeNodeTree(element.getLeft(), number));
        } else if (number > element.getData()) {
            element.setRight(removeNodeTree(element.getRight(), number));
        } else if (element.getLeft() != null && element.getRight() != null) {
            element.setData(minValue(element.getRight()));
            element.setRight(removeNodeTree(element.getRight(), number));
        } else {
            if (element.getLeft() != null) {
                element = element.getLeft();
            } else if (element.getRight() != null) {
                element = element.getRight();
            } else {
                element = null;
            }
        }

        return element;
    }

    private boolean searchElementTree(ListItem element, ListItem getHead) {
        if (getHead == null || element == null) {
            return false;
        }

        if (element.getData() == getHead.getData()) {
            return true;
        }

        if (element.getData() < getHead.getData()) {
            return searchElementTree(element, getHead.getLeft());
        } else {
            return searchElementTree(element, getHead.getRight());
        }

    }

    private void printTree(ListItem list) {
        if (list == null) {
            return;
        }

        System.out.print(list.getData() + " ");

        printTree(list.getLeft());
        printTree(list.getRight());
    }


    private Integer minValue(ListItem node) {
        if (node.getLeft() == null) {
            return node.getData();
        }

        return minValue(node.getLeft());
    }
}
