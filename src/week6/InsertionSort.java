package week6;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;
public class InsertionSort {
    /**
     * ý tưởng: duyệt từ vị trí thứ 2, mỗi lần duyệt lấy ra 1 phần tử so sánh với các số trước nó
     * nếu số trường lớn hơn thì kùi số đó về sau đến khi tìm đc vị trí đúng thì gán lại
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int sz = arr.length;
        for (int i = 1; i < sz; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = tmp;
        }
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        In in = new In("C:\\Users\\vanh2\\IdeaProjects\\DSA\\src\\week6\\4Kints.txt");
        int[] arr = in.readAllInts();
        insertionSort(arr);
        printArray(arr);
    }
}
