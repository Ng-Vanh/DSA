package Bonus;

import java.util.Scanner;

public class SegmentTree {
    int n;
    int[] arr;
    int[] tree;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        this.tree = new int[4 * n];
        build(1, 0, n - 1);
    }

    public void build(int v, int tl, int tr) {
        if (tl == tr) {
            tree[v] = arr[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(2 * v, tl, tm);
            build(2 * v + 1, tm + 1, tr);
            tree[v] = Math.max(tree[2 * v], tree[2 * v + 1]);
        }
    }

    public int query(int v, int tl, int tr, int l, int r) {
        if (l > r) {
            return Integer.MIN_VALUE;
        }
        if (l == tl && r == tr) {
            return tree[v];
        }
        int tm = (tl + tr) / 2;
        int left = query(2 * v, tl, tm, l, Math.min(r, tm));
        int right = query(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        SegmentTree segmentTree = new SegmentTree(arr);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            int result = segmentTree.query(1, 0, n - 1, l, r);
            System.out.println(result);
        }
    }
}
