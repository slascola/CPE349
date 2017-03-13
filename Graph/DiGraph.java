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
    private int[] indegrees() {
    	int N = graph.length;
    	int IN[] = new int[N];
		for (int i = 0; i < N; i++) {
			IN[i] = 0;
		}
    	for (int u = 0; u < N; u++) {
    		if (graph[u] != null) {
    			for (int v = 0; v < graph[u].size(); v++) {
    				IN[graph[u].get(v) -1]++;
    			}
    		}
    	}
    	return IN;
    }
    public int[] topSort() {
    	int N = graph.length;
    	int[] IN = indegrees();
    	int[] A = new int[N];
    	Queue<Integer> q = new LinkedList<>();
    	
    	for (int u = 0; u < N; u++) {
    		if (IN[u] == 0) {
    			q.add(u + 1);
    		}
    	}
    	int i = 0;
    	int u = 0;
    	while (!(q.isEmpty())) {
    		u = q.remove();
    		A[i] = u;
    		i++;
    		if (graph[u-1] != null) {
    			for (int v = 0; v < graph[u-1].size(); v++) {
    				IN[graph[u-1].get(v) - 1]--;
    				if (IN[graph[u-1].get(v) - 1] == 0) {
    					q.add(graph[u-1].get(v));
    				}
    			}
    		}
    	}
    	if (i != N) {
				System.out.println("ERROR: Graph is cyclic");
				A[0] = -1;
    	}
    	return A;
    }
    private class VertexInfo {
    	int distance;
    	int predecessor;
    	
    }
    private VertexInfo[] BFS(int s) {
		int N = graph.length;
		VertexInfo[] VA = new VertexInfo[N];
		
		for (int u = 0; u < N; u++) {
			VA[u] = new VertexInfo();
			VA[u].distance = -1;
			VA[u].predecessor = -1;
		}
		
		VA[s].distance = 0;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(s);
		
		int u = 0;
		while (!(Q.isEmpty())) {
			u = Q.remove();
			if (graph[u - 1] != null) {
				for (int v = 0; v < graph[u-1].size(); v++) {
					if (VA[graph[u-1].get(v) - 1].distance == -1) {
						VA[graph[u-1].get(v) - 1].distance = VA[u].distance + 1;
						VA[graph[u-1].get(v) - 1].predecessor = u;
						Q.add(graph[u-1].get(v));
					}
				}
			}
		}
		
		return VA;
	}
    public boolean isTherePath(int from, int to) {
		VertexInfo[] path = BFS(from);
		if (path[to - 1].distance >= 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public int lengthOfPath(int from, int to) {
		int length = 0;
		VertexInfo[] path = BFS(from);
		length = path[to - 1].distance;
		return length;
		
	}
	public void printPath(int from, int to) {
		VertexInfo[] VA = BFS(from);
		if (VA[to - 1].distance == -1) {
			System.out.println("There is no path");
		}
		else {
			String output = "";
			if (VA[to].predecessor == -1) {
				System.out.println("The path is: " + from + " -> " + to);
			}
			else {
				while (VA[to].predecessor != -1) {
					output = "-> " + to + " " + output;
					to = VA[to - 1].predecessor;
				}
				output = from + " " + output;
				System.out.println("The path is: " + output);
			}
		}
	}
}
