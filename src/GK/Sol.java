package GK;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        LinkedList<Integer>[] queues = new LinkedList[4];

        for (int i = 1; i <= 3; i++) {
            queues[i] = new LinkedList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            queues[1].add(i);
        }

        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1: {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    if (!queues[u].isEmpty()) {
                        int student = queues[u].pollFirst();
                        queues[v].addFirst(student);
                    }
                    break;
                }
                case 2: {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    if (queues[u].size() > 1) {
                        int student = queues[u].get(1);
                        queues[u].remove(1);
                        if (queues[v].isEmpty()) {
                            queues[v].addFirst(student);
                        } else {
                            queues[v].add(1, student);
                        }
                    }
                    break;
                }
                case 3: {
                    int u = sc.nextInt();
                    System.out.println(queues[u].size());
                    break;
                }
                case 4: {
                    int v = sc.nextInt();
                    if (queues[v].isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(queues[v].getFirst());
                    }
                    break;
                }
            }
        }

        sc.close();
    }


}

