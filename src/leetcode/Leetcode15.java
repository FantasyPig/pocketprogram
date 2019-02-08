package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (sum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{0,0,0});
        for (List a : result) {
            System.out.println(a);
        }
    }
}
