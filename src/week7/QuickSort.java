package week7;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int key = arr[(left + right) / 2];

        int pivot = findPivot(arr, left, right, key);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot, right);
    }

    private static int findPivot(int[] arr, int left, int right, int key) {
        int tmpLeft = left;
        int tmpRight = right;
        while (arr[tmpLeft] < key) {
            tmpLeft++;
        }
        while (arr[tmpRight] > key) {
            tmpRight--;
        }
        if (tmpLeft < right) {
            int tmp = arr[tmpLeft];
            arr[tmpLeft] = arr[tmpRight];
            arr[tmpRight] = tmp;
            tmpLeft++;
            tmpRight--;
        }
        return tmpLeft;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5, 3, 6, 9, 1, 2, 3, 4, 6, 2};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
