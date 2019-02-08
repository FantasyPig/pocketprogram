package leetcode;


import java.util.Stack;

public class Leetcode32 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Integer.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }


}
