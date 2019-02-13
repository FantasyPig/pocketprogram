package sort;

/**
 * 归并排序
 * 递归三条件：公式 + 终止条件
 * 分而治之
 */
public class MergeSort {

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        mergeSort(nums, start, (start + end) / 2);
        mergeSort(nums, (start + end) / 2 + 1, end);
        merge(nums, start, end);
    }

    private static void merge(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] tmpArr = new int[len];
        int flag = 0;
        int s1 = start;
        int s2 = (start + end) / 2 + 1;
        while (s1 < (start + end) / 2 + 1 && s2 <= end) {
            if (nums[s1] <= nums[s2]) {
                tmpArr[flag++] = nums[s1++];
            } else {
                tmpArr[flag++] = nums[s2++];
            }
        }
        while (s1 < (start + end) / 2 + 1) {
            tmpArr[flag++] = nums[s1++];
        }
        while (s2 <= end) {
            tmpArr[flag++] = nums[s2++];
        }
        int j = 0;
        for (int i = start; i <= end; ++i) {
            nums[i] = tmpArr[j++];
        }

    }

    public static void main(String[] args) {
        int[] nums = {3,67,33,2,5,0};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
