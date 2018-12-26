package sort;

public class QuickSort {

    public static void quickSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        doSort(nums, 0, len - 1);
    }

    private static void doSort(int[] nums, int start, int end) {
        if(end <= start) {
            return;
        }
        int j = start;
        for(int i = start; i < end; ++i) {
            if(nums[i] <= nums[end]) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++j;
            }
        }
        int tmp = nums[end];
        nums[end] = nums[j];
        nums[j] = tmp;
        doSort(nums, start, j - 1);
        doSort(nums, j, end);
    }

    public static void main(String[] args) {
        int[] list = {1,4,3,5,2,8,6};
        quickSort(list);
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}

