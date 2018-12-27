package leetcode;

public class Leetcode231 {

    public boolean solution(int n) {
        if (n <= 0) return false;
        return (n & (n -1)) == 0 ? true : false;
    }
}
