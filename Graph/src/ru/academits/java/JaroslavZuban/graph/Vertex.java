package ru.academits.java.JaroslavZuban.graph;

public class Vertex {
    private String label;
    private boolean visited;

    public Vertex(String label){
        this.label=label;
        this.visited=false;
    }

    public String getLabel(){
        return label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
