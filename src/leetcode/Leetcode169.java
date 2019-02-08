package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int val = map.get(num);
                if (val + 1 > len / 2) {
                    return num;
                }
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }
}
