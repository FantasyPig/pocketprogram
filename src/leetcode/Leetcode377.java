package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 组合总和
 * 上楼梯问题的变种
 */
public class Leetcode377 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        combinationSum4(nums, target);
    }

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], 1);
            for (int j = 0; j < i; ++j) {
                if (map.get(nums[i] - nums[j]) != null) {
                    map.put(nums[i], map.get(nums[i]) + map.get(nums[i] - nums[j]));
                }
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(nums[i] + " " + map.get(nums[i]));
        }
        return 0;
    }
}
