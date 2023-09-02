package week3;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class pairs {
    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> numberSet = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            if (numberSet.contains(num - k)) {
                count++;
            }
            if (numberSet.contains(num + k)) {
                count++;
            }
            numberSet.add(num);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();

        List<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < sz; i++) {
            int x = sc.nextInt();
            ar.add(x);
        }
        int res = pairs(2,ar);
        System.out.println(res);
    }
}
