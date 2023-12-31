package week2.sum;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean bnrSearch(int[] arr, int left, int right, int key){
        while (left <=right){
            int mid = left + (right-left) / 2;
            if(arr[mid] == key){
                return true;
            }else if(arr[mid] < key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        In in = new In("C:\\Users\\vanh2\\IdeaProjects\\DSA\\src\\week2\\sum\\2Kints.txt");
        int[] a = in.readAllInts();
        int count = 0;

        //Sum2:
        /*
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j <a.length ; j++) {
                if(a[i] + a[j] == 0){
                    System.out.println(a[i]+" "+a[j]);
                }
            }
        }
        */

        //Sum3: C1: for đến chết: O(n^3)
//        int count = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i+1; j < a.length; j++) {
//                for (int k = j+1; k < a.length; k++) {
//                    if(a[i] + a[j] + a[k] == 0){
//                       // System.out.println(a[i]+" "+a[j] +" "+a[k]);
//                        count++;
//                    }
//                }
//            }
//        }

        //C3: O(n^2log(n)

//        Arrays.sort(a);
//        int sz = a.length;
//        for (int i = 0; i < sz - 3 ; i++) {
//            for (int j = i+1; j < sz - 2; j++) {
//                int sum2 = a[i] + a[j];
//                int left = j+1;
//                int right = sz-1;
//                int tmp = -sum2;
//                if(bnrSearch(a,left,right,tmp)){
//                    count++;
//                }
//            }
//        }

        //C2: dùng 2 con trỏ left và right

        Arrays.sort(a);
        int n = a.length;
//        for (int i = 0; i < n - 2; i++) {
//            int left = i+1;
//            int right = n-1;
//            int cur = a[i];
//            while (left<right){
//                if(a[left] + a[right] == -cur){
//                    count ++;
//                    while (left < right && a[left] == a[left + 1]) left++;
//                    while (left < right && a[right] == a[right - 1]) right--;
//                    left++;
//                    right--;
//                } else if (a[left] + a[right] < -cur) {
//                    left++;
//                }else{
//                    right--;
//                }
//            }
//        }

        //Cach khac O(n^2)
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            for(int k = n-1; k > j+1; k--){
                while(j < k){
                    if(a[i] + a[j] + a[k] == 0){
                        count++;
                        j++;
                    }else if (a[i] + a[j] + a[k] < 0){
                        j++;
                    }else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);

        //N sum với N <=40 và a[i] < 10^9/ Đếm số bộ N số có tổng = 0

    }
}
