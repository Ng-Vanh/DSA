package GK;

import java.util.LinkedList;
import java.util.Scanner;

public class XepHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer>[] h = new LinkedList[3];

        for (int i = 0; i < 3; i++) {
            h[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            h[0].add(i + 1);
        }

        int query = scanner.nextInt();
        while (query-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                if (!h[u].isEmpty()) {
                    int person = h[u].poll();
                    h[v].addFirst(person);
                }else{
                    continue;
                }
            } else if (op == 2) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                if (h[u].size() >= 2 && h[v].size()>=1) {
                    int person = h[u].remove(1);
                    h[v].add(1, person);
                }else if(h[u].size() >= 2 && h[v].isEmpty()){
                    int person = h[u].remove(1);
                    h[v].add(0, person);
                }else{
                    continue;
                }
            } else if (op == 3) {
                int i = scanner.nextInt() - 1;
                System.out.println(h[i].size());
            } else if (op == 4) {
                int j = scanner.nextInt() - 1;
                if (!h[j].isEmpty()) {
                    System.out.println(h[j].getFirst());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
