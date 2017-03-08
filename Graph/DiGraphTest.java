
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

        char selection = input.next().charAt(0);
        while (selection != 'q') {
            if (selection == 'a') {
                System.out.println("Enter two integers representing from and to: ");
                int from = input.nextInt();
                int to = input.nextInt();
                graph.addEdge(from, to);
            }
            else if (selection == 'd') {
                System.out.println("Enter two integers representing from and to: ");
                int from = input.nextInt();
                int to = input.nextInt();
                graph.deleteEdge(from, to);
            }
            else if (selection == 'e') {
                System.out.println("Number of edges are: " + graph.edgeCount());
            }
            else if (selection == 'v') {
                System.out.println("Number of vertices are: " + graph.vertexCount());
            }
            else if (selection == 'p') {
                graph.print();
            }
        }
    }
}
