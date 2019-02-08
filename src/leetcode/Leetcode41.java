package leetcode;

public class Leetcode41 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int[] isUsed = new int[len + 1];
        for (int num : nums) {
            if (num > 0 && num <= len) {
                isUsed[num] = 1;
            }
        }
        for (int i = 1; i < len + 1; ++i) {
            if (isUsed[i] == 0) {
                return i;
            }
        }
        return len + 1;
    }
}
