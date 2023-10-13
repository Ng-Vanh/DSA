package week7;

public class MergeSort {
    public static int[] mergeSort(int[] arr, int left, int right) {
        // case based on:
        if (left == right) {
            return new int[]{arr[left]};
        }
        int middle = left + (right - left) / 2;
        int[] arr1 = mergeSort(arr, left, middle);
        int[] arr2 = mergeSort(arr, middle + 1, right);

        // merge two arrays
        return merge(arr1, arr2);
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int index = 0, index1 = 0, index2 = 0;
        int[] result = new int[arr1.length + arr2.length];

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                result[index] = arr1[index1];
                index1++;
            } else {
                result[index] = arr2[index2];
                index2++;
            }
            index++;
        }
        if (index1 == arr1.length) {
            while (index2 < arr2.length) {
                result[index++] = arr2[index2++];
            }
        } else if (index2 == arr2.length) {
            while (index1 < arr1.length) {
                result[index++] = arr1[index1++];
            }
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5, 3, 6, 9, 1, 2, 3, 4, 6, 2};
        int tmp[] = mergeSort(arr, 0, 9);
        printArray(tmp);
    }
}
