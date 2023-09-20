package week5;

public class SelectionSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minPosition = i;
            for (int j = 0; j < arr.length; j++) {
                if(arr[minPosition] < arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[minPosition];
                    arr[minPosition] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,6,1,2,4,5};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
