package week3.BTVN;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class CountEqualNumber {
    public static int C(int k, int n){
        if(k == 0 || k == n){
            return 1;
        }
        return C(k, n-1) + C(k-1, n-1);
    }
    public static List<Integer> toArrayList(int[] arr){
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    public static int CountEqual(int [] arr){
        int res = 0;
        Arrays.sort(arr);
        List<Integer> tmp = new ArrayList<Integer>();
        int cnt = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == arr[i+1]){
                cnt++;
            }else{
                if(cnt >= 2){
                    tmp.add(cnt);
                    cnt = 1;
                }else{
                    cnt = 1;
                }
            }
        }
        for (int i = 0; i < tmp.size(); i++) {
            res += C(2, tmp.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,2,3,4,3,3};
        int res = CountEqual(arr);
        System.out.println(res);
    }
}
