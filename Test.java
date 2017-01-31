import java.util.*;
import java.io.*;
public class Test {

    public static void main(String [] args) {
        int[][] A;
        int[][] B;
        int[][] C;
        String[] strArray;
        String line;
        int counter = 0;

        System.out.println("Enter the input file name: ");
        Scanner input = new Scanner(System.in);
        File inputFile = new File(input.nextLine());

        try {
            input = new Scanner(inputFile);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        String firstLineA = input.nextLine();
        strArray = firstLineA.split(" ");
        int rowsA = Integer.parseInt(strArray[0]);
        int colsA = Integer.parseInt(strArray[1]);
        A = new int[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            counter = 0;
            line = input.nextLine();
            strArray = line.split(" ");
            for (int j = 0; j < colsA; j++) {
                A[i][j] = Integer.parseInt(strArray[counter]);
                counter++;
            }
        }

        String firstLineB = input.nextLine();
        strArray = firstLineB.split(" ");
        int rowsB = Integer.parseInt(strArray[0]);
        int colsB = Integer.parseInt(strArray[1]);
        B = new int[rowsB][colsB];

//        if (colsA != rowsB) {
//            System.out.println("The sizes of the matrices make it so that multiplication cannot occur.\n");
//            System.exit(0);
//        }

        counter = 0;
        for (int i = 0; i < rowsB; i++) {
            counter = 0;
            line = input.nextLine();
            strArray = line.split(" ");
            for (int j = 0; j < colsB; j++) {
                B[i][j] = Integer.parseInt(strArray[counter]);
                counter++;
            }
        }

        C = new int[A.length][B[0].length];
        C = MatrixProduct.matrixProduct_DAC(A, B);

//        System.out.println("Product Matrix:");
//        for (int i = 0; i < C.length; i++) {
//            for (int j = 0; j < C[0].length; j++) {
//                System.out.print(C[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
