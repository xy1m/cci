package com.xy1m.cci.chapter04_tree_graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Route Between Nodes:
 * Given a directed graph, design an algorithm to  nd out whether there is a route between two nodes.
 */
public class Q4_1_RouteBetweenNodes {
    public static boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;
        Queue<Node> q = new LinkedList<>();
        for (Node u : g.vertices) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.poll();
            for (Node v : u.adjacents) {
                if (v.state == State.Unvisited) {
                    if (v == end) {
                        return true;
                    } else {
                        v.state = State.Visiting;
                        q.add(v);
                    }
                }
            }
            u.state = State.Visited;
        }
        return false;
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] tmp = new Node[6];
        tmp[0] = new Node("a", 3);
        tmp[1] = new Node("b", 0);
        tmp[2] = new Node("c", 0);
        tmp[3] = new Node("d", 1);
        tmp[4] = new Node("e", 1);
        tmp[5] = new Node("f", 0);

        tmp[0].addAdjacent(tmp[1]);
        tmp[0].addAdjacent(tmp[2]);
        tmp[0].addAdjacent(tmp[3]);

        tmp[3].addAdjacent(tmp[4]);
        tmp[4].addAdjacent(tmp[5]);

        for (int i = 0; i < 6; i++) {
            g.addNode(tmp[i]);
        }
        return g;
    }

    public static void main(String[] args) {
        Graph g = createNewGraph();
        Node[] vertices = g.vertices;
        Node start = vertices[3];
        Node end = vertices[5];
        System.out.println(search(g, start, end));
    }
}

class Node {
    Node[] adjacents;
    State state;

    int adjacentCount;
    String vertex;

    public Node(String vertex, int adjacentCount) {
        this.vertex = vertex;
        this.adjacentCount = 0;
        this.adjacents = new Node[adjacentCount];
    }

    public void addAdjacent(Node x) {
        if (adjacentCount < adjacents.length) {
            adjacents[adjacentCount++] = x;
        } else {
            System.out.println("No more adjacent can be added");
        }
    }
}

class Graph {
    public static int MAX_VERTICES = 6;
    Node[] vertices;
    int count;

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < vertices.length) {
            vertices[count++] = x;
        } else {
            System.out.println("Graph is full");
        }
    }
}

enum State {
    Unvisited,
    Visited,
    Visiting
}



