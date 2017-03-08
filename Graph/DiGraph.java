// Arya Karnik (akarnik@calpoly.edu), Stephanie Lascola (slascola@calpoly.edu)
// 03/10/17
// Project 5

import java.util.*;

public class DiGraph {
    private LinkedList<Integer>[] graph;

    public DiGraph(int N) {
        graph = new LinkedList[N];
    }
    
    public void addEdge(int from, int to) {
        from--;
        to--;
        if (!(graph[from].contains(to))) {
            graph[from].add(to);
        }
    }
    
    public void deleteEdge(int from, int to) {
        if (!graph[from].contains(to)) {
            System.out.println("Delete Edge Failed: No edge to be deleted");
        }
        else {
            int deleted = graph[from].indexOf(to);
            graph[from].remove(deleted);
        }
    }
    public int edgeCount() {
        int totalEdges = 0;
        for (int i = 0; i < graph.length; i++) {
            totalEdges += graph[i].size();
        }

        return totalEdges;
    }
    public int vertexCount() {
        return graph.length;
    }
    public void print() {
        for (int i = 0; i < graph.length; i++) {
            i++;
            System.out.println(i + "is connected to: ");
            i--;
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.println(graph[i].get(j) + ", ");
            }
            System.out.println();
        }
    }
}
