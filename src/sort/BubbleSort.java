package sort;

/*
 * do not forget stop the sort if no num changes!!!
 * that means do not forget flag
 */

public class BubbleSort {

    public static void sort(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length - 1; ++j) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (flag) {
                return;
            }
            flag = true;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
