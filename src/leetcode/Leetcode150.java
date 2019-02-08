package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String s : tokens) {
            if (!set.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int bInt = stack.pop();
                int aInt = stack.pop();
                int cInt = 0;
                if ("+".equals(s)) {
                    cInt = aInt + bInt;
                } else if ("-".equals(s)) {
                    cInt = aInt - bInt;
                } else if ("*".equals(s)) {
                    cInt = aInt * bInt;
                } else {
                    cInt = aInt / bInt;
                }
                stack.push(cInt);
            }
        }
        return stack.pop();
    }
}
