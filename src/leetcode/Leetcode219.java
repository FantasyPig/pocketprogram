package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int tmpMin = nums.length;
        List<Integer> tmpList;
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
               map.get(nums[i]).add(i);
               tmpList = map.get(nums[i]);
               if (tmpList.size() >= 2) {
                   tmpMin = tmpList.get(tmpList.size() - 1) - tmpList.get(tmpList.size() - 2);
                   if (tmpMin <= k) {
                       return true;
                   }
               }
            } else {
                tmpList = new LinkedList<>();
                tmpList.add(i);
                map.put(nums[i], tmpList);
            }
        }
        return false;
    }
}
