package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        cursion(candidates, target, 0, new LinkedList<>(), result);
        return result;
    }

    private void cursion(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if (target > 0) {
            for (int i = start; i < candidates.length; ++i) {
                curr.add(candidates[i]);
                cursion(candidates, target - candidates[i], i, curr, result);
                curr.remove(curr.size() - 1);
            }
        } else if (target == 0) {
            result.add(new LinkedList<>(curr));
        }


    }

}
