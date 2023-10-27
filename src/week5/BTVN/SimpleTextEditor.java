package week5.BTVN;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

public class SimpleTextEditor {
    //link: https://www.hackerrank.com/challenges/simple-text-editor/problem
    public static String deleteLast(int k, String S){
        if(k > S.length())
        {
            return "";
        }
        return S.substring(0,S.length() - k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = "";
        Stack<String> st = new Stack<>();
        Stack<Integer> lastNum = new Stack<>();
        int queries = sc.nextInt();
        while (queries -- > 0){
            int num = sc.nextInt();
            if(num == 1 || num == 2){
                lastNum.push(num);
            }
            if(num == 1){
                String add = sc.next();
                st.push(add);
                S +=add;
            }
            else if(num == 2){
                int numDelete = sc.nextInt();
                String tmp = S.substring(S.length() - numDelete);
                st.push(tmp);
                S = deleteLast(numDelete, S);
            }
            else if(num == 3){
                int k = sc.nextInt();
                System.out.println(S.charAt(k-1));
            } else if (num == 4) {
                int lastNumber = lastNum.pop();
                if(lastNumber == 1){
                    String strTmp = st.pop();
                    S = deleteLast(strTmp.length(), S);
                }else if(lastNumber == 2){
                    S += st.pop();
                }
            }
        }
    }
}
