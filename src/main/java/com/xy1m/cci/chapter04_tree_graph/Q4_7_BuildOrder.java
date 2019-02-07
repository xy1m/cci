package com.xy1m.cci.chapter04_tree_graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Build Order:
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second
 * project is dependent on the first project). All of a project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
 * EXAMPLE
 * Input:
 * projects: a, b, c, d, e, f
 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output: f, e, a, b, d, c
 */
public class Q4_7_BuildOrder {
    static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    static Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        int endOfList = addNonDependent(order, projects, 0);
        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            if (current == null) {
                return null;
            }
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decreaseDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getDependencies() == 0) {
                order[offset++] = project;
            }
        }
        return offset;
    }

    public static void main(String[] args) {
        Project[] projects = findBuildOrder(
                new String[]{"a", "b", "c", "d", "e", "f"},
                new String[][]{
                        {"a", "d"},
                        {"f", "b"},
                        {"b", "d"},
                        {"f", "a"},
                        {"d", "c"}
                });

        StringBuffer sb = new StringBuffer();
        for (Project p : projects) {
            sb.append(p.getName()).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String n) {
        name = n;
    }

    public void addNeighbour(Project node) {
        if (!map.containsKey(node.name)) {
            children.add(node);
            map.put(node.name, node);
            node.increaseDependencies();
        }
    }

    public void increaseDependencies() {
        dependencies++;
    }

    public void decreaseDependencies() {
        dependencies--;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public int getDependencies() {
        return dependencies;
    }
}

class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String from, String to) {
        Project startNode = getOrCreateNode(from);
        Project endNode = getOrCreateNode(to);
        startNode.addNeighbour(endNode);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}
