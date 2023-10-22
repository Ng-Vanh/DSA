package GK;

import java.util.Scanner;

public class UniF {
    static int[] parent = new int[100001];
    static int c;

    static int minn;

    public static int find(int u){
        if(parent[u]<=-1) return u;
        else return parent[u]=find(parent[u]);
    }

    public static void Union(int a, int b) {
        a=find(a);
        b=find(b);

        if(a==b) return;
        else {
            if(parent[a]<parent[b]) {
                parent[a]+=parent[b];
                if(minn<Math.abs(parent[a])) minn = Math.abs(parent[a]);
                parent[b]=a;
                c--;
            }
            else {
                parent[b]+=parent[a];
                if(minn<Math.abs(parent[b])) minn = Math.abs(parent[b]);
                parent[a]=b;
                c--;
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        c = n;
        minn = 1;
        for (int i=1;i<=n;i++){
            parent[i]=-1;
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
                if(parent[p]<0)
                    System.out.println(Math.abs(parent[p]));
                else System.out.println(Math.abs(parent[find(p)]));
            }
            if(ch==4){
                System.out.println(minn);
            }
        }
    }
}
