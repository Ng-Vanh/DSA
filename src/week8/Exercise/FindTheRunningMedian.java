package week8.Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindTheRunningMedian {
    //https://www.hackerrank.com/challenges/find-the-running-median/problem
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        List<Double> result = new ArrayList<>();

        for (int n: a){
            if (maxHeap.isEmpty() || n <= maxHeap.peek()) {
                maxHeap.offer(n);
            } else {
                minHeap.offer(n);
            }
            if (maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }else if (maxHeap.size() < minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }

            if(maxHeap.size() == minHeap.size()){
                double tmp = (maxHeap.peek() + minHeap.peek()) / 2.0;
                result.add(tmp);
            }else{
                result.add(Double.valueOf(maxHeap.peek()));
            }
        }

        return result;
    }
    /*
    * Độ phức tạp thuật toán: nLogn
    *
    * */
}
