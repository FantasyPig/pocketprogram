package sort;
/*
 * 插入排序：分已排序部分和未排序部分
 * 前n个数为已排序，将第n + 1个数插入
 * 即 -- 插入排序
 */
public class InsertionSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int j = i - 1;
            int value = nums[i];
            for (;j >= 0; --j) {
                if (nums[j] > nums[i]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,8,33,22};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
