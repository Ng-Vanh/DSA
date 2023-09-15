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
        List<Integer> arrayList = toArrayList(arr);
        Collections.sort(arrayList);
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < arrayList.size(); i++) {
            
        }

        return res;
    }
}
