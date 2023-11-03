package Week9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosetNumberVer2 {
    public static void mergeSort(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) {
            return; // Danh sách rỗng hoặc có ít hơn 2 phần tử đã được sắp xếp.
        }

        int n = arr.size();
        int mid = n / 2;

        // Tạo danh sách con cho hai nửa của danh sách ban đầu.
        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, n));

        // Sắp xếp hai nửa riêng lẻ.
        mergeSort(left);
        mergeSort(right);

        // Gộp hai nửa đã sắp xếp lại thành danh sách ban đầu.
        merge(arr, left, right);
    }

    private static void merge(List<Integer> arr, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k, left.get(i));
                i++;
            } else {
                arr.set(k, right.get(j));
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại từ danh sách con nào đó (nếu có).
        while (i < left.size()) {
            arr.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            arr.set(k, right.get(j));
            j++;
            k++;
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here

        if (arr == null || arr.size() < 2) {
            return new ArrayList<Integer>();
        }

        int minDifference = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<Integer>();
        mergeSort(arr);

        for (int i = 1; i < arr.size(); i++) {
            int currentDifference = Math.abs(arr.get(i) - arr.get(i - 1));

            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                result.clear();
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            } else if (currentDifference == minDifference) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }

        return result;
    }
}
