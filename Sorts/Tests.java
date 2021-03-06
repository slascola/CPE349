import java.util.*;

public class Tests {

    private static void generateArray(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt((50 - 0) + 1);
        }
    }

    private static void printArray(int []arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static boolean checkSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String [] args) {
        int []arr = new int[1];
        generateArray(arr, 1);
        System.out.println(checkSorted(arr));
        System.out.println("Sorted List with Quick Sort");
        Sorts.quickSort(arr, 1);
        //printArray(arr);
        //Sorts.selectionSort(arr, 10);
        System.out.println("List sorted?" + " " + checkSorted(arr));
    } 
}
