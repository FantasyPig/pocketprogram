package leetcode;

/**
 *
 */
public class Leetcode209 {

    /**
     * dp状态 : dp[i][j] i 加到 j 的 和
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < nums.length) {
            sum += nums[j++];
            while(sum >= s) {
                min = Integer.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
