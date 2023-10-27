package week5.BTVN;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class getMaxValue {
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        //link: https://www.hackerrank.com/challenges/maximum-element/problem?isFullScreen=true
        List<Integer> maxValues = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            int queryType = Integer.parseInt(parts[0]);

            switch (queryType) {
                case 1:
                    int x = Integer.parseInt(parts[1]);
                    stack.push(x);
                    if (maxStack.isEmpty() || x >= maxStack.peek()) {
                        maxStack.push(x);
                    }
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        int poppedValue = stack.pop();
                        if (poppedValue == maxStack.peek()) {
                            maxStack.pop();
                        }
                    }
                    break;
                case 3:
                    if (!maxStack.isEmpty()) {
                        maxValues.add(maxStack.peek());
                    }
                    break;
                default:
                    break;
            }
        }

        return maxValues;
    }

}
