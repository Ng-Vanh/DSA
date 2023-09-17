package week3.BTVN;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Sum4 {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\vanh2\\IdeaProjects\\DSA\\src\\week2\\sum\\1Kints.txt");
        int[] arr = in.readAllInts();

        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length -3; i++) {
            for (int j = i+1; j <arr.length -2 ; j++) {
                int left = j+1;
                int right = arr.length - 1;
                while (left < right){
                    int res = arr[i] + arr[j] + arr[left] + arr[right];
                    if(res == 0){
                        count++;
                        left++;
                        right--;
                    }
                    else if(res > 0){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
