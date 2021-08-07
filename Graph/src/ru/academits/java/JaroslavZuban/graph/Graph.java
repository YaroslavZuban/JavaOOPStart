package ru.academits.java.JaroslavZuban.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    private int vertexNumber;
    private Vertex[] vertexArray;
    private int[][] vertex;

    public Graph(int n) {
        this.vertex = new int[n][n];
        this.vertexArray = new Vertex[n];

        for (int[] ints : vertex) {
            Arrays.fill(ints, 0);
        }
    }

    public void insertVertex(String name) {
        Vertex v = new Vertex(name);
        vertexArray[vertexNumber++] = v;
    }

    public void insertEdge(int begin, int end) {
        vertex[begin][end] = 1;
        vertex[end][begin] = 1;
    }

    private int getUnvisitedVertex(int vertex) {
        for (int i = 0; i < vertexNumber; i++) {
            if (this.vertex[vertex][i] == 1 && !vertexArray[i].isVisited()) {
                return i;
            }
        }

        return -1;
    }

    public void depthFirstGraph(int v) {
        System.out.println();
        System.out.print("Обход графа в глубину: " + vertexArray[v].getLabel() + " -> ");

        vertexArray[v].setVisited(true);
        Stack<Integer> list = new Stack<>();
        list.push(v);

        while (!list.isEmpty()) {
            int adjVertex = getUnvisitedVertex((int) list.peek());

            if (adjVertex == -1) {
                list.pop();
            } else {
                vertexArray[adjVertex].setVisited(true);
                System.out.print(vertexArray[adjVertex].getLabel() + " -> ");
                list.push(adjVertex);
            }
        }

        for (int i=0;i<vertexNumber;i++) {
            vertexArray[i].setVisited(false);
        }
    }

    public void depthTravelGraph(int v) {
        System.out.println();
        System.out.print("Обход графа в ширину: " + vertexArray[v].getLabel() + " -> ");

        int vertex;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int currentVertex = queue.getFirst();

            while ((vertex = getUnvisitedVertex(currentVertex)) != -1) {
                vertexArray[vertex].setVisited(true);
                System.out.print(vertexArray[vertex].getLabel() + " -> ");
                queue.add(vertex);
            }
        }
    }
}
