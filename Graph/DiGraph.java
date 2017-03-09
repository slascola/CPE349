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
    	if (graph[from - 1] == null) {
    		graph[from - 1] = new LinkedList();
    		graph[from - 1].add(to);
    	}
    	else if (!(graph[from - 1].contains(to))) {
            graph[from - 1].add(to);
        }
    }
    
    public void deleteEdge(int from, int to) {
    	if (graph[from - 1] != null) {
    		if (!(graph[from - 1].contains(to))) {
    			System.out.println("Delete Edge Failed: No edge to be deleted");
    		}
    		else {
    			int deleted = graph[from - 1].indexOf(to);
    			graph[from - 1].remove(deleted);
    		}
    	}
    }
    public int edgeCount() {
        int totalEdges = 0;
        for (int i = 0; i < graph.length; i++) {
        	if (graph[i] != null) {
        		totalEdges += graph[i].size();
        	}
        }

        return totalEdges;
    }
    public int vertexCount() {
        return graph.length;
    }
    public void print() {
    	System.out.println("The graph is the following:");
        for (int i = 0; i < graph.length; i++) {
            i++;
            System.out.print(i + " is connected to: ");
            i--;
            if (graph[i] != null) {
            	for (int j = 0; j < graph[i].size(); j++) {
            		if (j != graph[i].size() - 1) {
            			System.out.print(graph[i].get(j) + ", ");
            		}
            		else {
            			System.out.print(graph[i].get(j));
            		}
            	}
            }
            System.out.println();
        }
    }
}
