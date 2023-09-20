package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> bigSorting(List<String> unsorted) {
        // Write your code here
        List<String> res = unsorted;

        Collections.sort(res);

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> li = new ArrayList<>();
        int sz = sc.nextInt();
        for (int i = 0; i < sz; i++) {
            String tmp =  sc.next();
            li.add(tmp);
        }
        List<String> res = bigSorting(li);
        for(String x: res){
            System.out.println(x);
        }
    }
}
