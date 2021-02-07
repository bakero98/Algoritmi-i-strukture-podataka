package peti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// vrste sortova

public class Peti {
    private static Peti instance;

    private int size;

    public static Peti getInstance() {
        if (instance == null) {
            instance = new Peti();
        }
        return instance;
    }

    public void peti() {
        startSorting();
    }

    private void startSorting() {
        Scanner input = new Scanner(System.in);

        System.out.print("Koliko brojeva sadrzi vas niz : ");
        int arraySize = input.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Unesite " + (i + 1) + " element : ");
            array[i] = input.nextInt();
        }

        System.out.println("\nOdaberite sort");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Shell Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");

        System.out.print("\nUnesite broj za odabrani sort : ");
        int choosenSort = input.nextInt();
        switch (choosenSort) {
            case 1:
                bubbleSort(array);
                break;
            case 2:
                insertionSort(array);
                break;
            case 3:
                shellSort(array);
                break;
            case 4:
                mergeSort(array);
                break;
            case 5:
                quickSort(array);
                break;
            default:
                System.out.println("Niste unijeli dobro");
        }
    }

    public void selectionSort(int[] list){
        for (int i = 0; i < list.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < list.length; j++){
                if (list[j] < list[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = list[index];
            list[index] = list[i];
            list[i] = smallerNumber;
        }
    }

    private void bubbleSort(int[] list) {
        System.out.println("Prije sortiranja : " + Arrays.toString(list));
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false; //If we don't switch in next iteration, no need for more loops
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true; //We swtiched so at least one more loop is needed
                }
            }
        }
        System.out.println("Nakon sortiranja : " + Arrays.toString(list));
    }

    private void insertionSort(int[] list) {
        System.out.println("Prije sortiranja : " + Arrays.toString(list));
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] >= currentElement; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
        System.out.println("Nakon sortiranja : " + Arrays.toString(list));
    }

    private void shellSort(int[] list) {
        System.out.println("Prije sortiranja : " + Arrays.toString(list));
        for (int gap = list.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < list.length; i++) {
                int tmp = list[i];
                int j;
                for (j = i; j >= gap && list[j - gap] > tmp; j -= gap) {
                    list[j] = list[j - gap];
                }
                list[j] = tmp;
            }
        }
        System.out.println("Nakon sortiranja : " + Arrays.toString(list));
    }

    private void mergeSort(int[] list) {
        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int[] secondHalf = new int[list.length - (list.length / 2)];
            System.arraycopy(list, list.length / 2, secondHalf, 0, list.length - (list.length / 2));
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] firstHalf, int[] secondHalf, int[] list) {
        System.out.println("Prije sortiranja : " + Arrays.toString(list));
        int current1 = 0; // Trenutni indeks u firstHalf
        int current2 = 0; // Trenutni indeks u secondHalf
        int current3 = 0; // Trenutni indeks u list

        while (current1 < firstHalf.length && current2 < secondHalf.length) {
            if (firstHalf[current1] < secondHalf[current2]) {
                list[current3++] = firstHalf[current1++];
            } else {
                list[current3++] = secondHalf[current2++];
            }
        }

        while (current1 < firstHalf.length) {
            list[current3++] = firstHalf[current1++];
        }

        while (current2 < secondHalf.length) {
            list[current3++] = secondHalf[current2++];
        }
        System.out.println("Nakon sortiranja : " + Arrays.toString(list));
    }

    public void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array list[first..last]
     */
    private int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }


    }
}
