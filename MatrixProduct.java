import java.io.*;
import java.util.*;


public class MatrixProduct {

    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        int[][] product = new int[A.length][B.length];
        
        if ((A.length != A[1].length) || (B.length != B[1].length) || (A.length != B.length) || (A[1].length != B[1].length) || (A.length % 2 != 0) || (B.length % 2 != 0)) {
            System.out.println("IllegalArgumentException: Invalid matrix sizes\n");
            System.exit(0);
            }
        else {
            product = matrixProduct_DAC(A, 0, 0, B, 0, 0, A.length);
        }
        return product;
    }

    private static int[][] matrixProduct_DAC(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
        int[][] C = new int[n][n];
        int[][] C11, C12, C21, C22;

        if (n == 1) {
            C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
        }
        else {
            //Recursive calls based off 0 or 1/2 of matrix
            C11 = addMatrices(matrixProduct_DAC(A, 0, 0, B, 0, 0, n/2), matrixProduct_DAC(A, 0, n/2, B, n/2, 0, n/2));
            C12 = addMatrices(matrixProduct_DAC(A, 0, 0, B, 0, n/2, n/2), matrixProduct_DAC(A, 0, n/2, B, n/2, n/2, n/2));
            C21 = addMatrices(matrixProduct_DAC(A, n/2, 0, B, 0, 0, n/2), matrixProduct_DAC(A, n/2, n/2, B, n/2, 0, n/2));
            C22 = addMatrices(matrixProduct_DAC(A, n/2, 0, B, 0, n/2, n/2), matrixProduct_DAC(A, n/2, n/2, B, n/2, n/2, n/2));
            
            // for (int i = 0; i < C.length; i++) {
            //     for (int j = 0; j < C.length; j++) {
            //         System.out.println(C[i][j])
            //     }
            // }

            //System.out.println((C11+1).length);

            System.out.println(Arrays.deepToString(C11)); 
            System.out.println(Arrays.deepToString(C12)); 
            System.out.println(Arrays.deepToString(C21)); 
            System.out.println(Arrays.deepToString(C22)); 

        }
        return C;
    }
    
    private static int[][] addMatrices(int[][] A, int[][]B) {
        int[][] added = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                added[i][j] = A[i][j] + B[i][j];
            }
        }
        return added;
    }
}
