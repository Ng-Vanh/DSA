package week3;

import java.util.*;

public class closestNum {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        if (arr == null || arr.size() < 2) {
            return new ArrayList<Integer>(); // Trả về danh sách trống nếu danh sách đầu vào rỗng hoặc chỉ có 1 phần tử.
        }

        int minDifference = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<Integer>();

        Collections.sort(arr);

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();
        List<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < sz; i++) {
            int x = sc.nextInt();
            ar.add(x);
        }

        List<Integer> res = new ArrayList<Integer>();
        res = closestNumbers(ar);
        for(int num : res){
            System.out.print(num+" ");
        }
    }
}
