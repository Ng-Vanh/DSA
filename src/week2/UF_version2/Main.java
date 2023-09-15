package week2.UF_version2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();
        int edge = sc.nextInt();

        quickUF qUF = new quickUF(sz);

        while(sc.hasNextInt()){
            int x = sc.nextInt();
            int y = sc.nextInt();

            qUF.union(x,y);
        }

        int tplt = qUF.getSoTPLT();
        if(tplt > 1 ){
            System.out.println(tplt);
            System.out.println("FAILED");
        }
        else if(tplt == 1){
            System.out.println(qUF.getSoCanhConect());
        }
    }
}
