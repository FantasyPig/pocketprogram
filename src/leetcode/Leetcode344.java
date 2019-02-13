package leetcode;

public class Leetcode344 {

    public static void reverseString(char[] s) {
        int len = s.length;
        char tmp;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        char[] s = {'w', 'x', 'h', 'n'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }

}
