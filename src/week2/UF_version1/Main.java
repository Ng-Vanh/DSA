package week2.UF_version1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();
        UF uf = new UF(sz);
        for(int i=0; i<6; i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(!uf.connected(p,q)){
                uf.union(p,q);
            }
        }
//        for(int i=0; i<sz; i++){
//            for(int j=i+1; j<sz; j++){
//                if(uf.connected(i,j)){
//                    System.out.println(i+" connect " + j);
//                }
//            }
//        }
        uf.getId(sz);

    }
}
