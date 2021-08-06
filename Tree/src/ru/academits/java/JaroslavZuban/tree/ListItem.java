package ru.academits.java.JaroslavZuban.tree;

import java.util.Objects;

public class ListItem<T extends Comparable> {
    private  T data;
    private ListItem<T> left;
    private ListItem<T> right;

    public ListItem(T  data){
        this.data=data;
    }

    public ListItem(T data,ListItem<T> left,ListItem<T> right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public ListItem(){}

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data=data;
    }


    public ListItem<T> getLeft() {
        return left;
    }

    public void setLeft(ListItem<T> left) {
        this.left = left;
    }

    public ListItem<T> getRight() {
        return right;
    }

    public void setRight(ListItem<T> right) {
        this.right = right;
    }

}
