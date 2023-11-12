package Bonus;

public class Vebo5 {
    public static final int N = 300005;
    public static int[] arr = new int[N];
    public static int[] tree = new int[4*N];
    public static void build(int id, int left, int right) {
        if (left == right) {
            tree[id] = arr[left];
            return;
        } else {
            int mid = (left + right) / 2;
            build(2 * id, left, mid);
            build(2 * id + 1, mid + 1, right);
            tree[id] = Math.max(tree[2 * id], tree[2 * id + 1]);
        }
    }
    public static int getMax(int id, int left, int right, int l, int r) {
        if (l > r) {
            return Integer.MIN_VALUE;
        }
        if (l == left && r == right) {
            return tree[id];
        }
        int mid = (left + right) / 2;
        int curleft = getMax(2 * id, left, mid, l, Math.min(r, mid));
        int curright = getMax(2 * id + 1, mid + 1, right, Math.max(l, mid + 1), r);
        return Math.max(curleft, curright);
    }

}
