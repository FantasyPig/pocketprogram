package leetcode;

/**
 * 最长上升子序列(子序列可不连续)
 * [10,9,2,5,3,7,101,18]
 */
public class Leetcode300 {


    public static void main(String[] args) {
        int[] example = {10,9,2,5,3,7,101,18};
        int result = way1(example);
        System.out.println(result);
    }
    /**
     * 迭代
     * @return
     */
    public static int way1(int[] nums) {
        int number = nums.length;
        int tail = nums[0];
        int[] result = new int[1];
        cursion(nums, number, 0, 1, tail, result);
        return result[0];
    }

    private static void cursion(int[] nums, int number, int index, int length, int tail, int[] result) {
        if (result[0] < length) {
            result[0] = length;
        }
        if (index >= number) {
            return;
        }
        cursion(nums, number, index + 1, length, tail, result);
        cursion(nums, number, index + 1, length, nums[index], result);
        if (nums[index] > tail) {
            cursion(nums, number, index + 1, length + 1, nums[index], result);
        }

    }

    /**
     * 动态规划
     * 状态 ：dp[i]:包含第i个元素的最长子序列长度
     * 状态方程 ：dp[i] = max(dp[j]) + 1;
     * @return
     */
    public static int way2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int result = 0;
        int tmpLength = 0;
        for (int i = 0; i < len; ++i) {
            tmpLength = 0;
            for (int j = 0; j < i; ++j) {
                if (dp[j] > tmpLength && nums[i] > nums[j]) {
                    tmpLength = dp[j];
                }
            }
            dp[i] = tmpLength + 1;
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
}
