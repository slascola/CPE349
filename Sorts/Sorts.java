/*Stephanie Lascola slascola@calpoly.edu
Arya Karnik akarnik@calpoly.edu
Project 1
January 20, 2017
*/

import java.util.*;

public class Sorts {

	public static void mergeSort(int[] arr, int N) {
		int[] tempArray = new int[N];
		mergeSort(arr, tempArray, 0, N-1);
	}

	private static void mergeSort(int[] original, int[] temp, int left, 
	 int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(original, temp, left, center);
			mergeSort(original, temp, center + 1, right);
			merge(original, temp, left, center + 1, right);
		}
	}
	private static void merge(int[] original, int[] temp, int left,
	 int right, int end) {
		int leftEnd = right - 1;
		int tempNdx = left;
		int numElements = end - left + 1;

		while ((left <= leftEnd) && (right <= end)) {
			if (original[left] <= original[right]) {
				temp[tempNdx++] = original[left++];
			}
			else {
				temp[tempNdx++] = original[right++];
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
	}
	
	public static void selectionSort(int[] arr, int N) {
		for (int i = 0; i < N - 1; i++) {
			int index = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[index]) {
					index = j;	
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}

	public static void quickSort(int[] arr, int N) {	
		quickSort(arr, 0, N-1);
	}

	private static void quickSort(int[] arr, int first, int last) {
		if (first < last) {
			setPivotToEnd(arr, first, last);
			int pivotIndex = splitList(arr, first, last);
			quickSort(arr, first, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, last);
		}
	}

	private static void setPivotToEnd(int[] arr, int left, int right) {	
		int center = (left + right) / 2;
		int temp = 0;

		if (arr[center] < arr[left]) {
			temp = arr[center];
			arr[center] = arr[left];
			arr[left] = temp;
		}
		if (arr[right] < arr[left]) {
			temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
		}
		if (arr[right] < arr[center]) {
			temp = arr[right];
			arr[right] = arr[center];
			arr[center] = temp;
		}
		//Return pivot to end
		temp = arr[center];
		arr[center] = arr[right - 1];
		arr[right - 1] = temp;
		
	}
	
	private static int splitList(int arr[], int first, int last) {
		int i = first;
		int j = last;
		int temp;
		int pivot = arr[last];

		while (true) {
			while (arr[++i] < pivot) {}
			while (arr[--j] > pivot) {}
			if (i < j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j]= temp;
			}
			else {
				break;
			}
		}
		temp = arr[i];
		arr[i] = arr[last];
		arr[last] = temp;
		return i;	
	}
}
