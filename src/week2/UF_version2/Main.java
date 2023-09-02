package week2.UF_version2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();
        int edge = sc.nextInt();
        quickUF qUF = new quickUF(sz);

        for(int i=0; i<edge; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            qUF.union(x,y);
        }

        qUF.getId(sz);
    }
}
