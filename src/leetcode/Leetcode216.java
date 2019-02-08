package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 */
public class Leetcode216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        cursion(n, k, 1, new LinkedList<>(), result);
        return result;
    }

    private void cursion(int n, int k, int start, List<Integer> curr, List<List<Integer>> result) {
        if (n > 0 && k > 0) {
            for (int i = start; i < 10; ++i) {
                curr.add(i);
                cursion(n - i, k - 1, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
        if(n == 0 && k == 0) {
            result.add(new LinkedList<>(curr));
        }

    }
}
