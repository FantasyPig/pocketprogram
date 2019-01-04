package leetcode;

/**
 * 乘积最大子序列
 * 1、cursion
 * 2、dp
 */
public class Leetcode152 {

    //动态规划
    public static int way2(int[] nums) {
        int number = nums.length;
        int[] tmpMaxs = new int[number];
        int[] tmpMins = new int[number];
        for (int i = 0; i < number; ++i) {
            if (i == 0) {
                tmpMaxs[i] = nums[i];
                tmpMins[i] = nums[i];
            } else {
                tmpMaxs[i] = Integer.max(Integer.max(nums[i], nums[i] * tmpMaxs[i - 1]), nums[i] * tmpMins[i -1]);
                tmpMins[i] = Integer.min(Integer.min(nums[i], nums[i] * tmpMaxs[i - 1]), nums[i] * tmpMins[i - 1]);
            }
        }
        int max = tmpMaxs[0];
        for (int i = 1; i < number; ++i) {
            if (max < tmpMaxs[i]) {
                max = tmpMaxs[i];
            }
        }
        return max;
    }

    //递归
    public static int way1(int[] nums) {
        int[] max = new int[2];
        max[1] = nums[0];
        int number = nums.length;
        for (int i = 0; i < number; ++i) {
            max[0] = nums[i];
            cursion(i, nums, max, nums[i]);
        }
        return max[1];
    }

    private static void cursion(int index, int[] nums, int[] max, int tmp) {

        if (tmp > max[0]) {
            max[0] = tmp;
        }

        if (max[1] < max[0]) {
            max[1] = max[0];
        }

        if (index + 1 < nums.length) {
            cursion(index + 1, nums, max, tmp * nums[index + 1]);
        }
    }

    public static void main(String[] args) {
        int[] testnums  = {-2,3,-4};
        System.out.println(way2(testnums));
    }
}
