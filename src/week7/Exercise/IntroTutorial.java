package week7.Exercise;

import java.util.List;

public class IntroTutorial {
    //https://www.hackerrank.com/challenges/tutorial-intro/problem
    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int left = 0;
        int res = -1;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) > V) {
                right = mid - 1;
            } else if (arr.get(mid) < V) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return res;
    }
}
