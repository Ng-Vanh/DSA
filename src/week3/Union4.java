package week3;

import java.util.Scanner;

public class Union4 {
    public static int [] root = new int[1000];

    public static int getRoot(int x){
        if(root[x] < 0) {
            return x;
        }
        return root[x] = getRoot(root[x]);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = n;
        for (int i = 0; i < n; i++) {
            root[i] = -1;
        }


        while(sc.hasNextInt()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            x = getRoot(x);
            y = getRoot(y);
            if(x != y){
                res--;
                if(root[x] > root[y]){ // size y lon hon
                    root[y] += root[x];
                    root[x] = y;
                }else{
                    root[x] +=root[y];
                    root[y] = x;
                }
            }
        }
        System.out.println(res);
    }
}
