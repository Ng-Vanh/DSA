package week4;

import java.util.Scanner;

public class Cycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int [][] array = new int[1000][1000];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        while (q-- > 0) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int d = sc.nextInt();

            if (d == 1) {
                for (int i = x; i <= u ; i++) {
                    int left = y;
                    int right = v;
                    while(left < right){
                        int tmp = array[i][left];
                        array[i][left] = array[i][right];
                        array[i][right] = tmp;
                        left++;
                        right--;
                    }
                }
            } else {
                for (int i = y; i <= v ; i++) {
                    int top = x;
                    int bottom = u;
                    while(x < u){
                        int tmp = array[top][i];
                        array[top][i] = array[bottom][i];
                        array[bottom][i] = tmp;
                        top++;
                        bottom--;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
