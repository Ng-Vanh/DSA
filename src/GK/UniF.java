package GK;

import java.util.Scanner;

public class UniF {
    static int[] id = new int[10001];
    static int c;

    static int MAX;

    public static int find(int u){
        if(id[u]<=-1) return u;
        else return id[u] = find(id[u]);
    }
    public static void Union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;
        else {
            if (id[a] < id[b]) {
                id[a] += id[b];
                if (MAX < Math.abs(id[a])) MAX = Math.abs(id[a]);
                id[b] = a;
                c--;
            } else {
                id[b] += id[a];
                if (MAX < Math.abs(id[b])) MAX = Math.abs(id[b]);
                id[a] = b;
                c--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        c = n;
        MAX = 1;
        for (int i=1;i<=n;i++){
            id[i]=-1;
        }
        for (int i=1;i<=m;i++){
            int ch = sc.nextInt();
            if(ch==1){
                int p =sc.nextInt();
                int q = sc.nextInt();
                Union(p,q);
            }
            if(ch==2){
                System.out.println(c);
            }
            if(ch==3){
                int p = sc.nextInt();
                if(id[p]<0)
                    System.out.println(Math.abs(id[p]));
                else System.out.println(Math.abs(id[find(p)]));
            }
            if(ch==4){
                System.out.println(MAX);
            }
        }
    }
}
