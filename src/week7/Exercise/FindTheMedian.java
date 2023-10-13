package week7.Exercise;

import java.util.Collections;
import java.util.List;

public class FindTheMedian {
    //https://www.hackerrank.com/challenges/find-the-median/problem
    public static void quickSort(int array[], int left, int right){
        if (left >=right) return;

        int pivot = partition(array, left, right);

        quickSort(array, left, pivot-1);
        quickSort(array, pivot+1, right);
    }
    public static int partition(int[] array, int left, int right){
        int pivot = array[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int tmp = array[i];
        array[i] = array[right];
        array[right] = tmp;
        return i;
    }
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        return arr.get(arr.size()/2);
    }
}
