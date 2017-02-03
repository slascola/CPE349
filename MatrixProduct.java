// Arya Karnik (akarnik@calpoly.edu), Stephanie Lascola (slascola@calpoly.edu)
// 02/03/17
// Project 2

import java.io.*;
import java.util.*;
public class MatrixProduct {

   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
      int[][] product = new int[A.length][B.length];
    
      if (A.length == 1 && B.length == 1) {
         product[0][0] = A[0][0] * B[0][0];
      }
        
      else if ((A.length == 1) || (B.length == 1) || (A.length != A[1].length) || (B.length != B[1].length) || (A.length != B.length) || (A[1].length != B[1].length) || (!powerOfTwo(A.length)) || (!powerOfTwo(B.length))) {
         throw new IllegalArgumentException();
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

   private static boolean powerOfTwo(int value) {
      if (value <= 0) {
         return false;
      }
      while (value > 1) {
         if (value % 2 != 0) {
            return false;
         }
         value /= 2;
      }
      return true;
   }

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
      int[][] product = new int[A.length][B.length];
     
      if (A.length == 1 && B.length == 1) {
         product[0][0] = A[0][0] * B[0][0];
      }
      else if ((A.length == 1) || (B.length == 1) || (A.length != A[1].length) || (B.length != B[1].length) || (A.length != B.length) || (A[1].length != B[1].length) || (!powerOfTwo(A.length)) || (!powerOfTwo(B.length))) {
         throw new IllegalArgumentException();
      }
      else {
         product = matrixProduct_Strassen(A, 0, 0, B, 0, 0, A.length);
      }
      return product;
   }

    private static int[][] matrixProduct_Strassen(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
      int[][] C = new int[n][n];
      int[][] S1, S2, S3, S4, S5, S6, S7, S8, S9, S10;
      int[][] P1, P2, P3, P4, P5, P6, P7;
      int[][] C11, C12, C21, C22;
      int[][] temp1, temp2, temp3, temp4;

      if (n == 1) {
         C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
      }
      else {
         S1 = subtractMatrices_Strassen(B, startRowB, startColB+n/2, B, startRowB+n/2, startColB+n/2, n/2);
         S2 = addMatrices_Strassen(A, startRowA, startColA, A, startRowA, startColA+n/2, n/2);
         S3 = addMatrices_Strassen(A, startRowA+n/2, startColA, A, startRowA+n/2, startColA+n/2, n/2);
         S4 = subtractMatrices_Strassen(B, startRowB+n/2, startColB, B, startRowB, startColB, n/2);
         S5 = addMatrices_Strassen(A, startRowA, startColA, A, startRowA+n/2, startColA+n/2, n/2);
         S6 = addMatrices_Strassen(B, startRowB, startColB, B, startRowB+n/2, startColB+n/2, n/2);
         S7 = subtractMatrices_Strassen(A, startRowA, startColA+n/2, A, startRowA+n/2, startColA+n/2, n/2);
         S8 = addMatrices_Strassen(B, startRowB+n/2, startColB, B, startRowB+n/2, startColB+n/2, n/2);
         S9 = subtractMatrices_Strassen(A, startRowA, startColA, A, startRowA+n/2, startColA, n/2);
         S10 = addMatrices_Strassen(B, startRowB, startColB, B, startRowB, startColB+n/2, n/2);

         P1 = matrixProduct_Strassen(A, startRowA, startColA, S1, 0, 0, n/2);
         P2 = matrixProduct_Strassen(S2, 0, 0, B, startRowB+n/2, startColB+n/2, n/2);
         P3 = matrixProduct_Strassen(S3, 0, 0, B, startRowB, startColB, n/2);
         P4 = matrixProduct_Strassen(A, startRowA+n/2, startColA+n/2, S4, 0, 0, n/2);
         P5 = matrixProduct_Strassen(S5, 0, 0, S6, 0, 0, n/2);
         P6 = matrixProduct_Strassen(S7, 0, 0, S8, 0, 0, n/2);
         P7 = matrixProduct_Strassen(S9, 0, 0, S10, 0, 0, n/2);

         temp1 = addMatrices_Strassen(P5, 0, 0, P4, 0, 0, n/2); 
         temp2 = subtractMatrices_Strassen(temp1, 0, 0, P2, 0, 0, n/2);
         C11 = addMatrices_Strassen(temp2, 0, 0, P6, 0, 0, n/2);
         C12 = addMatrices_Strassen(P1, 0, 0, P2, 0, 0, n/2);
         C21 = addMatrices_Strassen(P3, 0, 0, P4, 0, 0, n/2);
         temp3 = addMatrices_Strassen(P5, 0, 0, P1, 0, 0, n/2); 
         temp4 = subtractMatrices_Strassen(temp3, 0, 0, P3, 0, 0, n/2);
         C22 = subtractMatrices_Strassen(temp4, 0, 0, P7, 0, 0, n/2);

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

   private static int[][] addMatrices_Strassen(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
      int[][] C = new int[n][n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            C[i][j] = A[startRowA+i][startColA+j] + B[startRowB+i][startColB+j];
         }
      }
     return C;
   }

   private static int[][] subtractMatrices_Strassen(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
     int[][] C = new int[n][n];

     for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            C[i][j] = A[startRowA+i][startColA+j] - B[startRowB+i][startColB+j];
         }
      }
     return C;
   }
}

