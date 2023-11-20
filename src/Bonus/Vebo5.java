package Bonus;

import java.util.Scanner;

public class Vebo5 {
    public static final int N = 300005;
    public static long[] arr = new long[N];
    public static long[] tree = new long[4*N];
    public static void build(int id, int left, int right) {
        if (left == right) {
            tree[id] = arr[left];
            return;
        } else {
            int mid = (left + right) / 2;
            build(2 * id, left, mid);
            build(2 * id + 1, mid + 1, right);
            tree[id] = Math.min(tree[2 * id], tree[2 * id + 1]);
        }
    }
    public static void update(int id, int left, int right, int pos, long val) {
        if (left == right) {
            tree[id] = val;
            return;
        }
        int mid = (left + right) / 2;
        if (pos <= mid) {
            update(2 * id, left, mid, pos, val);
        } else {
            update(2 * id + 1, mid + 1, right, pos, val);
        }
        tree[id] = Math.min(tree[2 * id], tree[2 * id + 1]);
    }
    public static long getMin(int id, int left, int right, int l, int r) {
        if (l > r) {
            return Integer.MAX_VALUE;
        }
        if (l == left && r == right) {
            return tree[id];
        }
        int mid = (left + right) / 2;
        long curleft = getMin(2 * id, left, mid, l, Math.min(r, mid));
        long curright = getMin(2 * id + 1, mid + 1, right, Math.max(l, mid + 1), r);
        return Math.min(curleft, curright);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }
        build(1,1,n);
        int query = sc.nextInt();
        while(query-->0){
            int op = sc.nextInt();
            if(op == 1){
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(getMin(1,1,n,l,r));
            }else if (op == 2){
                int id = sc.nextInt();
                long v = sc.nextLong();
                arr[id] = v;
                update(1, 1, n, id, v);
            }
        }
    }

}
