package week6;

public class SelectionSort {
    /**
     * Kết thúc mỗi vòng for ta đưa vị trí phần tử nhỏ về đầu dãy
     * Độ phức tạp: O(n^2)
     * @param arr is the array  containing.
     */
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
