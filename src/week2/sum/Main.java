package week2.sum;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        In in = new In("C:\\Users\\vanh2\\IdeaProjects\\DSA\\src\\week2\\sum\\2Kints.txt");
        int[] a = in.readAllInts();

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
        /*
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                for (int k = j+1; k < a.length; k++) {
                    if(a[i] + a[j] + a[k] == 0){
                        System.out.println(a[i]+" "+a[j] +" "+a[k]);
                    }
                }
            }
        }
         */
        //C2: dùng 2 con trỏ left và right
        Arrays.sort(a);
        int n = a.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i+1;
            int right = n-1;
            int cur = a[i];
            while (left<right){
                if(a[left] + a[right] == -cur){
                    System.out.println(cur+" "+a[left]+" "+a[right]);
                    while (left < right && a[left] == a[left + 1]) left++;
                    while (left < right && a[right] == a[right - 1]) right--;
                    left++;
                    right--;
                } else if (a[left] + a[right] < -cur) {
                    left++;
                }else{
                    right--;
                }
            }
        }

    }
}
