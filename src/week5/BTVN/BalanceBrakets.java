package week5.BTVN;

import java.util.Stack;

public class BalanceBrakets {
    public static String isBalanced(String s) {
        // Write your code here
        //link: https://www.hackerrank.com/challenges/balanced-brackets/problem
        Stack<Character> st = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                if (st.isEmpty()) {
                    return "NO";
                }

                char wTop = st.pop();
                if (c == '}' && wTop != '{'
                        || c == ']' && wTop != '['
                        || c == ')' && wTop != '(') {
                    return "NO";
                }
            }
        }
        if (st.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String str = "(()";
        String res = isBalanced(str);
        System.out.println(res);
    }
}
