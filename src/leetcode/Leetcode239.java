package leetcode;


import java.util.PriorityQueue;

public class Leetcode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (heap.size() < k) {
                heap.offer(nums[i]);
            } else {
                result[j++] = heap.peek();
                heap.remove(nums[i - k]);
                heap.offer(nums[i]);
            }
        }
        result[result.length - 1] = heap.peek();
        return result;
    }
}
