package week7.Exercise;

import java.util.Scanner;

public class QuicksortInPlace {
    // https://www.hackerrank.com/challenges/quicksort3/problem
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    public static int partition(int[] arr, int left, int right) {
        int key = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= key) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        printArray(arr);


        return i;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 9, 8, 2, 7, 5};
        quickSort(arr, 0, arr.length - 1);
    }

}
