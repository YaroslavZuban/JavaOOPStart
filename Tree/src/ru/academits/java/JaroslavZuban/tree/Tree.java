package ru.academits.java.JaroslavZuban.tree;
import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable> {
    private ListItem<T> head;
    private int numberSheets;

    public Tree() {
        this.numberSheets = 0;
        this.head = new ListItem<>();
    }

    public int getNumberSheets() {
        return numberSheets;
    }

    public void addSheets(T element) {
        ListItem<T> listItem = new ListItem<>();
        listItem.setData(element);

        if (this.head.getData() == null) {
            this.head = listItem;
            this.numberSheets++;
        } else {
            ListItem<T> current = this.head;
            ListItem<T> prev = null;

            while (true) {
                prev = current;
                if ( (prev.getData()).compareTo(element)>=0) {
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

    public void printRecursion() {
        printRecursionTree(head);
    }

    public void printBreadthFirstTraversal(){
        Queue<ListItem<T>> queue=new LinkedList<>();
        ListItem<T> list=head;

        do{
            System.out.print(list.getData()+" ");

            if(list.getLeft()!=null){
                queue.add(list.getLeft());
            }

            if(list.getRight()!=null){
                queue.add(list.getRight());
            }

            if(!queue.isEmpty()){
                list=queue.poll();
            }
        }while (!queue.isEmpty());
    }

    public boolean searchElement(ListItem<T> element) {
        return searchElementTree(element, head);
    }


    public void removeNode(ListItem<T> element) {
        this.head = removeNodeTree(this.head, element.getData());
        this.numberSheets--;
    }

    private ListItem<T> removeNodeTree(ListItem<T> element, T number) {
            if(element == null)
                return null;

            if(number == element.getData()){
                ListItem<T> tmp;

                if(element.getRight() == null)
                    tmp = element.getLeft();
                else {
                    ListItem<T> ptr = element.getRight();

                    if(ptr.getLeft() == null){
                        ptr.setLeft(element.getLeft());
                        tmp = ptr;
                    } else {
                        ListItem<T> pmin = ptr.getLeft();

                        while(ptr.getLeft() != null){
                            ptr  = pmin;
                            pmin = ptr.getLeft();
                        }

                        ptr.setLeft(pmin.getRight());
                        pmin.setLeft(element.getLeft());
                        pmin.setRight(element.getRight());
                        tmp = pmin;
                    }
                }

                return tmp;
            } else if(number.compareTo( element.getData())<0) {
                element.setLeft(removeNodeTree(element.getLeft(), number));
            } else {
                element.setRight(removeNodeTree(element.getRight(), number));
            }

            return element;
        }

    private boolean searchElementTree(ListItem<T> element, ListItem<T> getHead) {
        if (getHead == null || element == null) {
            return false;
        }

        if (element.getData() == getHead.getData()) {
            return true;
        }

        if ((element.getData()).compareTo( getHead.getData())<0) {
            return searchElementTree(element, getHead.getLeft());
        } else {
            return searchElementTree(element, getHead.getRight());
        }

    }

    private void printRecursionTree(ListItem<T> list) {
        if (list == null) {
            return;
        }

        System.out.print(list.getData() + " ");
        printRecursionTree(list.getLeft());
        printRecursionTree(list.getRight());
    }



    private T minValue(ListItem<T> node) {
        if (node.getLeft() == null) {
            return node.getData();
        }

        return minValue(node.getLeft());
    }
}
