// Arya Karnik (akarnik@calpoly.edu), Stephanie Lascola (slascola@calpoly.edu)
// 03/10/17
// Project 5

import java.util.*;

public class DiGraphTest {

    public static void main(String args[]) {
        System.out.println("Enter the number of vertices ");
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        int N = input.nextInt();  
        DiGraph graph = new DiGraph(N);

        System.out.println("Choose one of the following operations:");
        System.out.println("-add edge (enter a)");
        System.out.println("-delete edge (enter d)");
        System.out.println("-edge count (enter e):");
        System.out.println("-vertex count (enter v)");
        System.out.println("-print graph (enter p)");
        System.out.println("-is there a path (enter i)");
        System.out.println("-length of the path (enter l)");
        System.out.println("-shortest path (enter s)");
        System.out.println("-Quit (enter q)");

        while (quit == false) {
            String temp = input.nextLine();
            if (temp.length() == 1) {
                switch (temp.charAt(0)) {
                    case 'a': 
                        int from = input.nextInt();
                        int to = input.nextInt();
                        graph.addEdge(from, to);
                        System.out.println("(" + from + ", " + to + ") edge is now added to the graph");
                        break;
            
                    case 'd':
                        from = input.nextInt();
                        to = input.nextInt();
                        graph.deleteEdge(from, to);
                        System.out.println("(" + from + ", " + to + ") edge is now deleted from the graph");
                        break;
            
                    case 'e': 
                        System.out.println("Number of edges is: " + graph.edgeCount());
                        break;
            
                    case 'v':
                        System.out.println("Number of vertices is: " + graph.vertexCount());
                        break;
            
                    case 'p':
                        graph.print();
                        break;
                    case 't':
                        int[] A = new int[N];
                        A = graph.topSort();
                        if (A[0] != -1) {
                            for (int i = 0; i < A.length; i++) {
                                if (i != A.length - 1) {
                                    System.out.print(A[i] + ", ");
                                }
                                else {
                                    System.out.print(A[i]);
                                }
                            }
                            System.out.println();
                        }
                        break;
                    case 'i':
                        from = input.nextInt();
                        to = input.nextInt();
                        System.out.println("Is there a path from " + from + " to " + to + ": " + graph.isTherePath(from, to));
                        break;
                    case 'l':
                        from = input.nextInt();
                        to = input.nextInt();
                        System.out.println("Length of path is: " + graph.lengthOfPath(from, to));
                        break;
                    case 's':
                        from = input.nextInt();
                        to = input.nextInt();
                        graph.printPath(from, to);
                        break;
                    case 'q':
                        System.out.println("Goodbye.");
                        quit = true;
                        break;
                    case 'b':
                        from = input.nextInt();
                        graph.printTree(from);
                        break;
                    default:
                        System.out.println("Invalid menu choice");
                        break;
                }
            }
            else if (temp.length() == 0) {
                continue;
            }
            else {
                System.out.println("Invalid menu choice");
            }

        }
        
    }
}
