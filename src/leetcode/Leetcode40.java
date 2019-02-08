package leetcode;

import java.util.*;

public class Leetcode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        cursion(candidates, target, 0, new LinkedList<>(), result);
        return result;
    }

    private void cursion(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if (target > 0) {
            for (int i = start; i < candidates.length; ++i) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                curr.add(candidates[i]);
                cursion(candidates, target - candidates[i], i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        } else if (target ==0) {
            result.add(new ArrayList<>(curr));
        }
    }
}
