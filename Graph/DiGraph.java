import java.util.*;
public class DiGraph {
	private LinkedList<Integer> graph;
	graph = new LinkedList<Integer>();
	
	public void addEdge(int from, int to) {
		if (graph[from] == null) {
			graph[from] = new LinkedList<Integer>();
			grpah[from].add(to);
		}
		else {
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
		return graph.length*(graph.length - 1);
	}
	public int vertexCount() {
		return graph.length;
	}
	public void print() {
		for (int i = 1; i < graph.length + 1; i++) {
			System.out.println(i + " " + ":" + " " + graph[i]);
		}
	}
	
}
