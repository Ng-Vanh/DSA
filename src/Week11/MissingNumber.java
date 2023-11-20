package Week11;

import java.util.*;

public class MissingNumber {
    //https://www.hackerrank.com/challenges/missing-numbers/problem
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer,Integer> mp1 = new HashMap<Integer,Integer>();
        Map<Integer,Integer> mp2 = new HashMap<Integer,Integer>();

        for(int num: arr){
            mp1.put(num, mp1.getOrDefault(num, 0) + 1);
        }
        for(int num:brr){
            mp2.put(num, mp2.getOrDefault(num,0) + 1);
        }
        for(int key: mp2.keySet()){
            if(!mp1.containsKey(key)){
                result.add(key);
            }else{
                if(mp2.get(key) > mp1.get(key)){
                    result.add(key);
                }
            }
        }
        return result;
    }
    //Cach 2
    public static List<Integer> missingNumbersVer2(List<Integer> arr, List<Integer> brr){
        List<Integer> result = new ArrayList<Integer>();
        Collections.sort(arr);
        Collections.sort(brr);
        int i = 0;
        int j = 0;
        while(j < brr.size() || i < arr.size()){
          if(arr.get(i) > brr.get(j)){
             if(!result.contains(brr.get(j))){
                 result.add(brr.get(j));
                 j++;
             }
          }else if(arr.get(i) < brr.get(j)){
              j++;
          }else if(arr.get(i).equals(brr.get(j))){
              i++;
              j++;
          }
        }
        return result;
    }
}
