// Arya Karnik (akarnik@calpoly.edu), Stephanie Lascola (slascola@calpoly.edu)
// 01/20/17
// Project 1

import java.util.*;

public class Sorts1 {

    public static int mergeSort(int[] arr, int N) {
        int counter = 0;
        int[] tempArray = new int[N];
        counter = mergeSort(arr, tempArray, 0, N-1);
        return counter;
    }

    private static int mergeSort(int[] original, int[] temp, int left, 
     int right) {
        int counter = 0;
        if (left < right) {
            int center = (left + right) / 2;
            counter += mergeSort(original, temp, left, center);
            counter += mergeSort(original, temp, center + 1, right);
            counter += merge(original, temp, left, center + 1, right);
        }
        return counter;
    }
    private static int merge(int[] original, int[] temp, int left,
     int right, int end) {
        int counter = 0;
        int leftEnd = right - 1;
        int tempNdx = left;
        int numElements = end - left + 1;

        while ((left <= leftEnd) && (right <= end)) {

            if (original[left] <= original[right]) {
                temp[tempNdx++] = original[left++];
                counter++;
            }
            else {
                temp[tempNdx++] = original[right++];
                counter++;
            }
        }
        
        while (left <= leftEnd) {
            temp[tempNdx++] = original[left++];
        }
        
        while (right <= end) {
            temp[tempNdx++] = original[right++];
        }

        for (int i = 0; i < numElements; i++, end--) {
            original[end] = temp[end];
        }
        return counter;
    }
    
    public static long selectionSort(int[] arr, int N) {
        long counter = 0;
        for (int i = 0; i < N - 1; i++) {
            int index = i;
            for (int j = i + 1; j < N; j++) {
                counter++;
                if (arr[j] < arr[index]) {
                    index = j;  
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return counter;
    }

    public static int quickSort(int[] arr, int N) {    
        int counter = 0;
        counter = quickSort(arr, 0, N-1);
        return counter;
    }

    private static int quickSort(int[] arr, int first, int last) {
        int counter = 0;
        int[] pivotIndexAndCount = new int[2];
        if (first < last) {
            counter += setPivotToEnd(arr, first, last);
            pivotIndexAndCount = splitList(arr, first, last);
            counter += pivotIndexAndCount[1];
            counter += quickSort(arr, first, pivotIndexAndCount[0] - 1);
            counter += quickSort(arr, pivotIndexAndCount[0] + 1, last);
        }
        return counter;
    }

   private static int setPivotToEnd(int[] arr, int left, int right) { 
        int counter = 0;
        int center = (left + right) / 2;
        int temp = 0;

        counter++;
        if (arr[center] < arr[left]) {
            temp = arr[center];
            arr[center] = arr[left];
            arr[left] = temp;
        }
        counter++;
        if (arr[right] < arr[left]) {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        counter++;
        if (arr[right] > arr[center]) {
            temp = arr[right];
            arr[right] = arr[center];
            arr[center] = temp;
        }
        return counter;
        
    }
    
    private static int[] splitList(int arr[], int first, int last) {
        int[] pivotIndexAndCount = new int[2];
        int counter = 0;
        int i = first;
        int j = last-1;
        int temp;
        int pivot = arr[last];

        while (i <= j) {
            while (arr[i] < pivot) {
                counter++;
                i++;
            }
            counter++;
            while (i <= j) {
                counter++;
                if (arr[j] > pivot) {
                    j--;
                }
                else {
                    break;
                }
            }
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j]= temp;
                i++;
                j--;
            }
        }
        temp = arr[i];
        arr[i] = arr[last];
        arr[last] = temp;
        pivotIndexAndCount[0] = i;
        pivotIndexAndCount[1] = counter;
        return pivotIndexAndCount;   
    }
}
