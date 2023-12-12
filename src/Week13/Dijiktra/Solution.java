package Week13.Dijiktra;


import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int query = scanner.nextInt();
        while(query-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            long weight[][] = new long[n + 1][n + 1];
            for (long[] row : weight)
                Arrays.fill(row, 1000000l);
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt(), y = scanner.nextInt();
                long curWeight = scanner.nextLong();
                if (weight[x][y] > curWeight) {
                    weight[x][y] = curWeight;
                    weight[y][x] = curWeight;
                }
            }
            Stack<Integer> stack1 = new Stack<Integer>();
            int start = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                if (i != start) {
                    stack1.push(i);
                }
            }
            Stack<Integer> stack2 = new Stack<Integer>();
            stack2.push(start);
            weight[start][start] = 0;
            while (!stack1.isEmpty()) {
                int minValue = Integer.MAX_VALUE, pos = -1;
                for (int i = 0; i < stack1.size(); i++) {
                    int edge1To = stack1.elementAt(i);
                    weight[start][edge1To] = Math.min(weight[start][edge1To],
                            weight[start][stack2.peek()] + weight[stack2.peek()][stack1.elementAt(i)]);
                    if (weight[start][stack1.elementAt(i)] <= minValue) {
                        minValue = (int) weight[start][stack1.elementAt(i)];
                        pos = i;
                    }
                }
                stack2.push(stack1.elementAt(pos));
                stack1.removeElementAt(pos);
            }
            for (int i = 1; i <= n; i++) {
                if (i != start && weight[start][i] != 1000000l) {
                    System.out.print(weight[start][i] + " ");
                } else if (i != start) {
                    System.out.print("-1" + " ");
                }
            }
            System.out.println();
        }
    }
}



