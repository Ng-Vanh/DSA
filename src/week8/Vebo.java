package week8;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Vebo {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int query = sc.nextInt();
        for (int i = 0; i < size; i++){
            int n = sc.nextInt();
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
        }
        while(query-->0){
            int op = sc.nextInt();
            if(op == 1){
                int n = sc.nextInt();
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
            } else if (op == 2) {
                if (!maxHeap.isEmpty()) {
                    maxHeap.poll();
                }
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }else if (op == 3){
                if (!maxHeap.isEmpty()){
                    System.out.println(maxHeap.peek());
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
