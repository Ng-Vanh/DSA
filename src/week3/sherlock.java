package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sherlock {
    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        if (arr == null ) {
            return "NO";
        }
        if(arr.size() == 1){
            return "YES";
        }
        int sum = 0, sumL = 0;
        for(int i = 0; i<arr.size(); i++){
            sum += arr.get(i);
        }

        for(int i=0; i<arr.size(); i++){
            if(i==0){
                sumL +=0;
            }else{
                sumL+=arr.get(i-1);
            }
            int sumR = sum - sumL-arr.get(i);
            if(sumL == sumR){
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        int sz = sc.nextInt();
        for (int i = 0; i < sz; i++) {
            int x = sc.nextInt();
            ar.add(x);
        }
        String res = balancedSums(ar);
        System.out.println(res);
    }
}
