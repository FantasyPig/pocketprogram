package sort;

/*
 * 将nums分成已排序和未排序两个部分
 * 每次将未排序的最小数加到已排序的最后
 * 即选择排序
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int min = i;
            int j = i;
            for (; j < nums.length; ++j) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,32,8,67,0,22};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");;
        }
    }
}
