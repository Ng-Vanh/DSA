package GK;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> dQueue = new LinkedList<>();

        int fun = scanner.nextInt();
        int query = scanner.nextInt();

        int customerId = 1;
        while(query -- >0){
            int option = scanner.nextInt();

            if (option == 1) {
                dQueue.add(customerId);
                customerId++;
            } else if (option == 2) {
                if (!dQueue.isEmpty()) {
                    System.out.println(dQueue.pollFirst());
                } else {
                    System.out.println(0);
                }
            } else if (option == 3) {
                if (!dQueue.isEmpty()) {
                    System.out.println(dQueue.pollLast());
                } else {
                    System.out.println(0);
                }
            } else if (option == 4) {
                System.out.println(dQueue.size());
            } else if (option == 5) {
                int u = scanner.nextInt();
                if (u > 0 && u <= dQueue.size()) {
                    int element = 1;
                    for (int customer : dQueue) {
                        if (element == u) {
                            System.out.println(customer);
                            break;
                        }
                        element++;
                    }
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}
