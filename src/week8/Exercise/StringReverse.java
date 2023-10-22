package week8.Exercise;

import java.util.Scanner;

public class StringReverse {
    //: https://www.hackerrank.com/challenges/java-string-reverse/problem
    public static boolean isPalindromeString(String str){
        int l = 0;
        int r = str.length() - 1;
        while(l < r){
            if(str.charAt(l)!= str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(isPalindromeString(str)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
