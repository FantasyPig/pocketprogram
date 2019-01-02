package leetcode;

/**
 * 爬楼梯
 */
public class Leetcode70 {

    public int climbStairs(int n) {
        int result = 3;
        int[] tmp = {1,2};
        if (n <= 2) {
            return tmp[n - 1];
        }
        for (int i = 3; i <= n; ++i) {
            result = tmp[0] + tmp[1];
            tmp[0] = tmp[1];
            tmp[1] = result;
        }
        return result;
    }
}
