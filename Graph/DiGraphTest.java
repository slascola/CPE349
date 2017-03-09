// Arya Karnik (akarnik@calpoly.edu), Stephanie Lascola (slascola@calpoly.edu)
// 03/10/17
// Project 5

import java.util.*;

public class DiGraphTest {

    public static void main(String args[]) {
        System.out.println("Enter the number of vertices ");
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();  
        DiGraph graph = new DiGraph(N);

        System.out.println("Choose one of the following operations:");
        System.out.println("-add edge (enter a)");
        System.out.println("-delete edge (enter d)");
        System.out.println("-edge count (enter e):");
        System.out.println("-vertex count (enter v)");
        System.out.println("-print graph (enter p)");
        System.out.println("-Quit (enter q)");

        String line = input.next();
        char selection = line.charAt(0);
        while (selection != 'q') {
        	switch (selection) {
        	case 'a': 
                int from = input.nextInt();
                int to = input.nextInt();
                graph.addEdge(from, to);
                System.out.println("Edge (" + from + ", " + to + ") was added");
                break;
            
        	case 'd':
                from = input.nextInt();
                to = input.nextInt();
                graph.deleteEdge(from, to);
                System.out.println("Edge (" + from + ", " + to + ") was deleted");
                break;
            
        	case 'e': 
                System.out.println("Number of edges are: " + graph.edgeCount());
                break;
            
        	case 'v':
                System.out.println("Number of vertices are: " + graph.vertexCount());
                break;
            
        	case 'p': {
                graph.print();
                break;
            }
            default: {
            	System.out.println("Invalid menu choice");
            }
        	}
            line = input.next();
            selection = line.charAt(0);
            
//            line = input.nextLine();
//            if (line.contains("/n")) {
//            	line = input.nextLine();
//            }
//            if (line.length() > 1) {
//            	System.out.println("Invalid menu choice");
//            	line = input.nextLine();
//            	selection = line.charAt(0);
//            }
//            else {
//            	selection = line.charAt(0);
//            }
        }
        System.out.println("Goodbye");
    }
}
