package Week9.BtapHackkerank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaHashMap {
    // https://www.hackerrank.com/challenges/phone-book/problem
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> user = new HashMap<String, Integer>();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            user.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            if (user.containsKey(s)) {
                System.out.println(s + "=" + user.get(s));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
