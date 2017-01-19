import java.util.*;

public class SortTimes {
    public static void main(String[] args) {
        int[] elements1 = new int[160000];
        int[] elements2 = new int[160000];
        int[] elements3 = new int[160000];

        for (int i = 5000; i <= 160000; i*=2) {
            for (int j = 0; j < i; j++) {
                Random rand = new Random();
                elements1[j] = rand.nextInt((i - 0) + 1);
                elements2[j] = rand.nextInt((i - 0) + 1);
                elements3[j] = rand.nextInt((i - 0) + 1);
            }
            long selectionStartTime = System.nanoTime();
            Sorts.selectionSort(elements1, i);
            long selectionEndTime = System.nanoTime();
            long mergeStartTime = System.nanoTime();
            Sorts.mergeSort(elements2, i);
            long mergeEndTime = System.nanoTime();
            long quickStartTime = System.nanoTime();
            Sorts.quickSort(elements3, i);
            long quickEndTime = System.nanoTime();

            long selectionTime = (selectionEndTime - selectionStartTime) / 1000000;
            long mergeTime = (mergeEndTime - mergeStartTime) / 1000000;
            long quickTime = (quickEndTime - quickStartTime) / 1000000;

            System.out.println("N=" + i + " T_ss=" + selectionTime + " T_ms=" + mergeTime + " T_qs=" + quickTime);
            


            for (int j = 0; j < i; j++) {
                Random rand = new Random();
                elements1[j] = rand.nextInt((i - 0) + 1);
                elements2[j] = rand.nextInt((i - 0) + 1);
                elements3[j] = rand.nextInt((i - 0) + 1);
            }
            selectionStartTime = System.nanoTime();
            Sorts.selectionSort(elements1, i);
            selectionEndTime = System.nanoTime();
            mergeStartTime = System.nanoTime();
            Sorts.mergeSort(elements2, i);
            mergeEndTime = System.nanoTime();
            quickStartTime = System.nanoTime();
            Sorts.quickSort(elements3, i);
            quickEndTime = System.nanoTime();

            selectionTime = (selectionEndTime - selectionStartTime) / 1000000;
            mergeTime = (mergeEndTime - mergeStartTime) / 1000000;
            quickTime = (quickEndTime - quickStartTime) / 1000000;

            System.out.println("N=" + i + " T_ss=" + selectionTime + " T_ms=" + mergeTime + " T_qs=" + quickTime);
           


            for (int j = 0; j < i; j++) {
                Random rand = new Random();
                elements1[j] = rand.nextInt((i - 0) + 1);
                elements2[j] = rand.nextInt((i - 0) + 1);
                elements3[j] = rand.nextInt((i - 0) + 1);
            }
            selectionStartTime = System.nanoTime();
            Sorts.selectionSort(elements1, i);
            selectionEndTime = System.nanoTime();
            mergeStartTime = System.nanoTime();
            Sorts.mergeSort(elements2, i);
            mergeEndTime = System.nanoTime();
            quickStartTime = System.nanoTime();
            Sorts.quickSort(elements3, i);
            quickEndTime = System.nanoTime();

            selectionTime = (selectionEndTime - selectionStartTime) / 1000000;
            mergeTime = (mergeEndTime - mergeStartTime) / 1000000;
            quickTime = (quickEndTime - quickStartTime) / 1000000;

            System.out.println("N=" + i + " T_ss=" + selectionTime + " T_ms=" + mergeTime + " T_qs=" + quickTime);
            


            for (int j = 0; j < i; j++) {
                Random rand = new Random();
                elements1[j] = rand.nextInt((i - 0) + 1);
                elements2[j] = rand.nextInt((i - 0) + 1);
                elements3[j] = rand.nextInt((i - 0) + 1);
            }
            selectionStartTime = System.nanoTime();
            Sorts.selectionSort(elements1, i);
            selectionEndTime = System.nanoTime();
            mergeStartTime = System.nanoTime();
            Sorts.mergeSort(elements2, i);
            mergeEndTime = System.nanoTime();
            quickStartTime = System.nanoTime();
            Sorts.quickSort(elements3, i);
            quickEndTime = System.nanoTime();

            selectionTime = (selectionEndTime - selectionStartTime) / 1000000;
            mergeTime = (mergeEndTime - mergeStartTime) / 1000000;
            quickTime = (quickEndTime - quickStartTime) / 1000000;

            System.out.println("N=" + i + " T_ss=" + selectionTime + " T_ms=" + mergeTime + " T_qs=" + quickTime);


            for (int j = 0; j < i; j++) {
                Random rand = new Random();
                elements1[j] = rand.nextInt((i - 0) + 1);
                elements2[j] = rand.nextInt((i - 0) + 1);
                elements3[j] = rand.nextInt((i - 0) + 1);
            }
            selectionStartTime = System.nanoTime();
            Sorts.selectionSort(elements1, i);
            selectionEndTime = System.nanoTime();
            mergeStartTime = System.nanoTime();
            Sorts.mergeSort(elements2, i);
            mergeEndTime = System.nanoTime();
            quickStartTime = System.nanoTime();
            Sorts.quickSort(elements3, i);
            quickEndTime = System.nanoTime();

            selectionTime = (selectionEndTime - selectionStartTime) / 1000000;
            mergeTime = (mergeEndTime - mergeStartTime) / 1000000;
            quickTime = (quickEndTime - quickStartTime) / 1000000;

            System.out.println("N=" + i + " T_ss=" + selectionTime + " T_ms=" + mergeTime + " T_qs=" + quickTime);
            System.out.println();
        }
    }
}






