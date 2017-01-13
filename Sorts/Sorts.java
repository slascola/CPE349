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
}
