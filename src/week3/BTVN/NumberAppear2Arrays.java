package week3.BTVN;

import java.util.ArrayList;
import java.util.List;

public class NumberAppear2Arrays {
    public static List<Integer> findNumberAppear2Arrays(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<Integer>();
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < arr1.length && pointer2 < arr2.length){
            if(arr1[pointer1] == arr2[pointer2]){
                res.add(arr1[pointer1]);
                pointer1++;
                pointer2++;
            }
            else if(arr1[pointer1] < arr2[pointer2]){
                pointer1++;
            }else{
                pointer2++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 4, 5, 6, 7, 8, 12, 15, 17};
        int[] arr2 = new int[]{1, 2, 3, 5, 6, 12, 14, 22, 28};
        List<Integer> res = findNumberAppear2Arrays(arr1, arr2);

        for(int num: res){
            System.out.print(num + " ");//2 5 6 12
        }
    }
}
