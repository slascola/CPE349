import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Math;

public class GameProblem {
    
    public static void main(String args[]) {
        int[][] gameBoard;
        String rowLine;
        String[] rowArray;

        System.out.println("Enter the input file name: ");
        Scanner input = new Scanner(System.in);
        File inputFile = new File(input.nextLine());

        try {
            input = new Scanner(inputFile);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        String firstLine = input.nextLine();  
        String[] strArray = firstLine.split(" ");
        int row = Integer.parseInt(strArray[0]);
        int col = Integer.parseInt(strArray[1]);

        gameBoard = new int[row][col];

        for (int i = 0; i < row; i++) {
            rowLine = input.nextLine();  
            rowArray = rowLine.split(" ");
            for (int j = 0; j < col; j++) {
                gameBoard[i][j] = Integer.parseInt(rowArray[j]);
            }
        }
        game(row, col, gameBoard);
            
    }

    public static void game(int n, int m, int[][] A) {
        int[][] maxScores = new int[n][m];
        char[][] R = new char[n][m];

        maxScores[n-1][m-1] = A[n-1][m-1];

        for (int j = m-2; j >=0; j--) {
            if (maxScores[n-1][j + 1] >= 0) {
                maxScores[n-1][j] = maxScores[n-1][j + 1] + A[n-1][j];
                R[n-1][j] = 'R';
            }
            else {
                maxScores[n-1][j] = A[n-1][j];
                R[n-1][j] = 'E';
            }
        }

        for (int i = n-2; i >=0; i--) {
            //maxScores[i][m-1] = Math.max(maxScores[i + 1][m-1], 0) + A[i][m-1]; 
            if (maxScores[i + 1][m-1] >= 0) {
                maxScores[i][m-1] = maxScores[i + 1][m-1] + A[i][m-1];
                R[i][m-1] = 'D';
            }
            else {
                maxScores[i][m-1] = A[i][m-1];
                R[i][m-1] = 'E';
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                if (maxScores[i+1][j] >= maxScores[i][j+1]) {
                    maxScores[i][j] = maxScores[i+1][j] + A[i][j];
                    R[i][j] = 'D';
                }
                else {
                    maxScores[i][j] = maxScores[i][j+1] + A[i][j];
                    R[i][j] = 'R';
                }
            }
        }

        findMaxValue(maxScores, R);
    }

    private static void findMaxValue(int[][] maxScores, char[][] R) {
        int maxValue = 0;
        int xStartCoord = 0;
        int yStartCoord = 0;

        for (int i = 0; i < maxScores.length; i++) {
            for (int j = 0; j < maxScores[i].length; j++) {
                if (maxScores[i][j] > maxValue) {
                   maxValue = maxScores[i][j];
                   xStartCoord = i;
                   yStartCoord = j;
                }
            }
        }
        
        findPath(maxScores, xStartCoord, yStartCoord, R, maxValue);
    }

    private static void findPath(int[][] maxScores, int xStartCoord, int yStartCoord, char[][] R, int maxValue) {
        int i = xStartCoord;
        int j = yStartCoord;

        xStartCoord++;
        yStartCoord++;
        System.out.println("Best score: " + maxValue);
        System.out.print("Best route: [" + xStartCoord + "," + yStartCoord + "]");
        xStartCoord--;
        yStartCoord--;

        while (R[i][j] != 'E') {
            if (R[i][j] == 'R') {
                j++;
            }
            else {
                i++;
            }
            i++;
            j++;
            System.out.print(" to [" + i + "," + j + "]");
            i--;
            j--;
        }
        System.out.print(" to exit\n");
    }
}
