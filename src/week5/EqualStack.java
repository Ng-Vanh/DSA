package week5;

import java.util.List;

public class EqualStack {
    //link: https://www.hackerrank.com/challenges/equal-stacks/problem
    public static int getSumArray(List<Integer> h){
        int res = 0;
        for (int i = 0; i < h.size(); i++) {
            res+=h.get(i);
        }
        return res;
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int sum1 = getSumArray(h1);
        int sum2 = getSumArray(h2);
        int sum3 = getSumArray(h3);

        int p1 = 0, p2 = 0, p3 = 0;

        while (true) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            int minSum = Math.min(sum1, Math.min(sum2, sum3));

            while (sum1 > minSum) {
                sum1 -= h1.get(p1);
                p1++;
            }

            while (sum2 > minSum) {
                sum2 -= h2.get(p2);
                p2++;
            }

            while (sum3 > minSum) {
                sum3 -= h3.get(p3);
                p3++;
            }
        }
    }
}
