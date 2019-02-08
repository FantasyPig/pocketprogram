package leetcode;

import java.util.Stack;

public class Leetcode5 {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i != 0) {
                if (s.charAt(i) == stack.peek()) {
                    int tmpStart = i - 1;
                    int tmpIndex = i + 1;
                    int tmpMax = 2;
                    for (int m = stack.size() - 2; m >= 0; --m) {
                        if (tmpIndex >= s.length()) {
                            break;
                        }
                        if (s.charAt(tmpIndex++) == stack.get(m)) {
                            tmpMax += 2;
                            tmpStart -= 1;

                        }
                    }
                    if (tmpMax > maxLength) {
                        maxLength = tmpMax;
                        start = tmpStart;
                    }
                }
                if (i + 1 < s.length() && stack.peek() == s.charAt(i + 1)) {
                    int tmpStart = i - 1;
                    int tmpIndex = i + 2;
                    int tmpMax = 3;
                    for (int n = stack.size() - 2; n >= 0; --n) {
                        if (tmpIndex >= s.length()) {
                            continue;
                        }
                        if (s.charAt(tmpIndex++) == stack.get(n)) {
                            tmpMax += 2;
                            tmpStart -= 1;

                        }
                    }
                    if (tmpMax > maxLength) {
                        maxLength = tmpMax;
                        start = tmpStart;
                    }
                }
            }
            stack.add(s.charAt(i));
        }
        System.out.println(start + " " + maxLength);
        return s.substring(start, start + maxLength);
    }
}
