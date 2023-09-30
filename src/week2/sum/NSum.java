package week2.sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NSum {
    public static List<Integer> sinhArraySum(int[] arr){
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < arr.length; i++) {
            int tmp = res.size();
            for (int j = 0; j < tmp; j++) {
                res.add(arr[i] + res.get(j));
            }
        }
        return res;
    }

    public int count(List<Integer> arr){
        int res = 0;
        Collections.sort(arr);
        int mid = arr.size()/2;
        int arr1[] = new int[1000000];
        int arr2[] = new int[1000000];
        for (int i = 1; i < mid; i++) {
            arr1[i] = arr.get(i);
        }
        for (int i = mid; i < arr.size(); i++) {
            int j = 0;
            arr2[j++] = arr.get(i);
        }
        // two sum for arr1 and arr2
        int l1 = 0, l2 = 0;
        int r1 = arr1.length - 1;
        int r2 = arr2.length - 1;
        while (l1 <= r1){
            if(arr1[l1] + arr1[r1] == 0){
                res++;
            }else if(arr1[l1] + arr1[r1] < 0){
                l1++;
            }else{
                r1--;
            }
        }
        while (l2 <= r2){
            if(arr2[l2] + arr2[r2] == 0){
                res++;
            }else if(arr2[l2] + arr2[r2] < 0){
                l2++;
            }else{
                r2--;
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            int tmp = 0 - arr1[i];
            int tl2 = 0;
            int tr2 = arr2.length - 1;
            while (tl2 <= tr2){
                if(arr2[tl2] + arr2[tr2] == 0){
                    res++;
                }else if(arr2[tl2] + arr2[tr2] < 0){
                    tl2++;
                }else{
                    tr2--;
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int []arr = new int[]{1,-1,0};
        List<Integer> re = sinhArraySum(arr);
        for(int x: re){
            System.out.print(x+" ");
        }
    }
}
