package ru.academits.java.JaroslavZuban.tree;

import java.util.Objects;

public class ListItem {
    private  Integer data;
    private ListItem left;
    private ListItem right;

    public ListItem(Integer  data){
        this.data=data;
    }

    public ListItem(Integer data,ListItem left,ListItem right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public ListItem(){}

    public Integer getData(){
        return data;
    }

    public void setData(Integer data){
        this.data=data;
    }


    public ListItem getLeft() {
        return left;
    }

    public void setLeft(ListItem left) {
        this.left = left;
    }

    public ListItem getRight() {
        return right;
    }

    public void setRight(ListItem right) {
        this.right = right;
    }

}
