package leetcode;

public class LeetCode191 {

    public static int solution(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            ++count;
        }
        return count;
    }
}
