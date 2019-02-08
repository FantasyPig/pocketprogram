package leetcode;

public class Leetcode283 {

    public void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >=0; --i) {
            if (nums[i] == 0) {
                doChange(nums, i);
            }
        }
    }

    private void doChange(int[] nums, int i) {
        while(!(i == nums.length - 1 || nums[i + 1] == 0)) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
            ++i;
        }
    }
}
