package week7.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        //https://www.hackerrank.com/challenges/quicksort1/problem
        List<Integer> equal = new ArrayList<Integer>();
        List<Integer> less = new ArrayList<Integer>();
        List<Integer> greater = new ArrayList<Integer>();
        equal.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) == arr.get(0)) {
                equal.add(arr.get(i));
            } else if (arr.get(i) < arr.get(0)) {
                less.add(arr.get(i));
            } else {
                greater.add(arr.get(i));
            }
        }
        less.addAll(equal);
        less.addAll(greater);
        return less;
    }
}
