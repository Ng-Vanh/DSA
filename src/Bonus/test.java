package Bonus;

import java.util.*;


public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(N, (a, b) -> Integer.compare(b, a));
        long totalProfit = 0;

        for (int i = 0; i < N; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int u = scanner.nextInt();
                maxHeap.add(u);
            } else {
                int v = scanner.nextInt();
                if (!maxHeap.isEmpty()) {
                    totalProfit += maxHeap.poll();
                }
            }
        }

        System.out.println(totalProfit);
    }
}