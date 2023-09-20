package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        StackByLinkedList st = new StackByLinkedList();
        for (int i = 0; i < 10; i++) {
            st.push(i);
        }
        st.print();
        st.pop();
        st.print();
        System.out.println(st.pop());
    }
}
