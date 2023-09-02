package week2.sum;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();
        int [] arr = new int[sz];
        for (int i = 0; i < sz; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < sz; i++) {
            for(int j = i+1; j<sz; j++){
                if(arr[i] + arr[j] == 0){
                    System.out.println("( "+arr[i] + " ; " + arr[j] + " )");
                }
            }
        }
    }
}
