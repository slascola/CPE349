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

        System.out.println("Enter the number of coins and the coin values in decreasing order:");
        Scanner input = new Scanner(System.in);
        String firstLine = input.nextLine();
        if (firstLine.length() == 1) {
            String[] strArray = firstLine.split(" ");
            k = Integer.parseInt(strArray[0]);
            d = new int[k];

            for (int i = 0; i < k; i++){
                String nextLine = input.nextLine();
                String[] valueArray = nextLine.split(" "); 
                d[i] = Integer.parseInt(valueArray[0]);
            }
            // System.out.println("k: " + k);
            // System.out.println("d: " + Arrays.toString(d));
        }
        else {
            String[] strArray = firstLine.split(" ");
            k = Integer.parseInt(strArray[0]);
            d = new int[k];
            result = new int[k];
            for (int i = 0; i < k; i++){
                d[i] = Integer.parseInt(strArray[i+1]);
            }
        }
        // System.out.println("k: " + k);
        // System.out.println("d: " + Arrays.toString(d));

        while (n > 0) {
            System.out.println("Enter a value for n: positive value if needs change or 0 to quit:");
            n = input.nextInt();
            if (n == 0) {
                System.exit(0);
            }

            result = change_DP(n, d);

            System.out.println("Amount: " + n);
            for (int i = 0; i < k; i++) {
                if (result[i] != 0) {
                    System.out.print(result[i] + "*" + d[i] + "c + ");
                }
            }
            System.out.println();


        // Amount: 87
        // Optimal distribution: 3*25c + 1*10c +2*1c
        // Optimal coin count: 6
        // Attention: the formatting of 
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

        System.out.println("a: " + Arrays.toString(A));
        System.out.println("c: " + Arrays.toString(C));

        while (n > 0) {
            curIndex = A[n];
            result[curIndex]++;
            n-=d[curIndex];
        }

        return result;
    }
}
