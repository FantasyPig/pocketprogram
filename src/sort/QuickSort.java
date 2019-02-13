package sort;

/**
 *
 */
public class QuickSort {

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int compareNum = nums[end];
        int j = start;
        for (int i = start; i < end; ++i) {
            if (nums[i] <= compareNum) {
                if (i != j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                ++j;
            }
        }
        int tmp = nums[end];
        nums[end] = nums[j];
        nums[j] = tmp;
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = {1,9,2,8,3,4};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
