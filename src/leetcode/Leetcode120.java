package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 三角形最小路径和
 * 动态规划步骤
 * 1、表示状态
 * 2、状态推导方程式
 */
public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        for (int i = rows - 1; i > 0; --i) {
            List<Integer> row = triangle.get(i - 1);
            List<Integer> rowUnder = triangle.get(i);
            int rowLen = row.size();
            for (int j = 0; j < rowLen; ++j) {
                row.set(j, row.get(j) + min(rowUnder.get(j), rowUnder.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    private static int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

}
