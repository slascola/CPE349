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
            C11 = addMatrices(matrixProduct_DAC(A, startRowA, startColA, B, startRowB, startColB, n/2), 
             matrixProduct_DAC(A, startRowA, startColA+n/2, B, startRowB+n/2, startColB, n/2));
            C12 = addMatrices(matrixProduct_DAC(A, startRowA, startColA, B, startRowB, startColB+n/2, n/2),
             matrixProduct_DAC(A, startRowA, startColA+n/2, B, startRowB+n/2, startColB+n/2, n/2));
            C21 = addMatrices(matrixProduct_DAC(A, startRowA+n/2, startColA, B, startRowB, startColB, n/2),
             matrixProduct_DAC(A, startRowA+n/2, startColA+n/2, B, startRowB+n/2, startColB, n/2));
            C22 = addMatrices(matrixProduct_DAC(A, startRowA+n/2, startColA, B, startRowB, startColB+n/2, n/2),
             matrixProduct_DAC(A, startRowA+n/2, startColA+n/2, B, startRowB+n/2, startColB+n/2, n/2));

            for (int i = 0; i < C11.length; i++) {
                for (int j = 0; j < C11.length; j++) {
                    C[i][j] = C11[i][j];
                }
            }

            for (int i = 0; i < C12.length; i++) {
                for (int j = 0; j < C12.length; j++) {
                    C[i][j+n/2] = C12[i][j];
                }
            }

            for (int i = 0; i < C21.length; i++) {
                for (int j = 0; j < C21.length; j++) {
                    C[i+n/2][j] = C21[i][j];
                }
            }

            for (int i = 0; i < C22.length; i++) {
                for (int j = 0; j < C22.length; j++) {
                    C[i+n/2][j+n/2] = C22[i][j];
                }
            }
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
