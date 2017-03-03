// Arya Karnik (akarnik@calpoly.edu), Stephanie Lascola (slascola@calpoly.edu)
// 03/03/17
// Project 4

import java.io.*;
import java.util.*;

public class ChangeMaker {

    public static void main(String args[]) {
        int k = 0;
        int[] d;
        int n = 10;
        int[] result; 
        int count = 0;
        int firstHit = 0;

        System.out.println("Enter the number of coin-denominations and set of coin values:");
        Scanner input = new Scanner(System.in);
        
        k = input.nextInt();
        d = new int[k];
        for (int i = 0; i < k; i++) {
            d[i] = input.nextInt();
        }

        while (n > 0) {
            System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
            n = input.nextInt();
            if (n == 0) {
                System.out.println("Thanks for playing. Good Bye.");
                System.exit(0);
            }

            result = change_DP(n, d);
            System.out.println("DP algorithm results");
            System.out.println("Amount: " + n);
            for (int i = 0; i < k; i++) {
                if (result[i] != 0) {
                    if (firstHit != 0) {
                        System.out.print(" + ");
                    }
                    System.out.print(result[i] + "*" + d[i] + "c");
                    count+=result[i];
                    firstHit = 1;
                }
            }
            System.out.println();
            System.out.println("Optimal coin count: " + count);
            System.out.println();
            firstHit = 0;
            count = 0;
            
            result = change_greedy(n, d);
            System.out.println("Greedy algorithm results");
            System.out.println("Amount: " + n);
            for (int i = 0; i < k; i++) {
                if (result[i] != 0) {
                    if (firstHit != 0) {
                        System.out.print(" + ");
                    }
                    System.out.print(result[i] + "*" + d[i] + "c");
                    count+=result[i];
                    firstHit = 1;
                }
            }
            System.out.println();
            System.out.println("Optimal coin count: " + count);
            System.out.println();
            firstHit = 0;
            count = 0;
        }

    }

    public static int[] change_DP(int n, int[] d) {
        int[] C = new int[n+1];
        int[] A = new int[n+1];
        int[] result = new int[d.length];
        int curIndex = -1;

        C[0] = 0;

        for (int j = 1; j <= n; j++) {
            int minValue = Integer.MAX_VALUE;
            int aIndex = -1;
            for (int k = 0; k < d.length; k++) {
                if (j >= d[k]) {
                    if ((C[j-d[k]]) < minValue) {
                        minValue = (C[j-d[k]]);
                        aIndex = k;
                    }
                }
            }
            C[j] = minValue + 1;
            A[j] = aIndex;
        } 
        while (n > 0) {
            curIndex = A[n];
            result[curIndex]++;
            n-=d[curIndex];
        }
        return result;
    }
    
    public static int[] change_greedy(int n, int[] d) {
        int[] result = new int[d.length];
        int count = 0;
        
        while (count < d.length && n >= 0) {
            if (d[count] <= n) {
                while (n - d[count] >= 0) {
                    n-=d[count];
                    result[count]++;
                }
            }
            count++;
        }
        return result;
    }
}
