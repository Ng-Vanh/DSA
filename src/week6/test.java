package week6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int idx = 0;
        int res = 0;
        Map<Integer,Integer> mp= new HashMap<>();
        for(int x: arr){
            if (mp.containsKey(x)) {
                int tmp = mp.get(x);
                mp.put(x, tmp + 1);
            } else {
                // Nếu x chưa tồn tại, đặt giá trị mặc định là 1
                mp.put(x, 1);
            }
        }
        for (Map.Entry<Integer, Integer> tmp : mp.entrySet()){

        }
        return res;
    }
    public static void main(String[] args) {
        String s = "";
    }
}
