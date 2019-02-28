package leetcode;

public class Leetcode60 {

    public int minPathSum(int[][] grid) {
        int[][] dp = grid;
        if (dp == null) {
            return 0;
        }
        int col = dp[0].length;
        int row = dp.length;
        for (int i = 1; i < row; ++i) {
            dp[i][0] += dp[i - 1][0];
        }
        for (int i = 1; i < col; ++i) {
            dp[0][i] += dp[0][i - 1];
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = dp[i][j] + Integer.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}
