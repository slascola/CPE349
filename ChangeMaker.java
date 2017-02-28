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

        System.out.println("Enter the number of coins and the coin values in decreasing order:");
        Scanner input = new Scanner(System.in);
        String firstLine = input.nextLine();
        if (firstLine.length() == 1) {
            String[] strArray = firstLine.split(" ");
            k = Integer.parseInt(strArray[0]);
            d = new int[k];

            String nextLine = input.nextLine();
            String[] valueArray = nextLine.split(" ");
            for (int i = 0; i < k; i++) { 
                d[i] = Integer.parseInt(valueArray[i]);
            }
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
        while (n > 0) {
            System.out.println("Enter a value for n: positive value if needs change or 0 to quit:");
            n = input.nextInt();
            if (n == 0) {
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
}
