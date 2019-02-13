package search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,5,6,7,8};
        System.out.println(search1(nums, 4));
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找大于等于给定值的第一个元素
     * 极客时间版权所有: https://time.geekbang.org/column/article/80458
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                if (mid >= 1 && nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (mid <= len - 2 && nums[mid + 1] >= target) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            } else {
                int index = mid;
                while (index - 1 >= 0 && nums[index - 1] == target) {
                    --index;
                }
                return index;
            }
        }
        return -1;
    }
}
