package leetcode;

public class Leetcode27 {

    public static void main(String[] args) {
        int[] list = {3,2,2,3};
        removeElement(list, 3);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        for (int m = 0; m < nums.length; ++m) {
            System.out.print(nums[m]);
        }
        return i;

    }
}
