package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 121,122,123,309,188,714.
 * 股票买卖
 * way 1 : cursion
 * way 2 : dp (so difficult)
 */
public class Leetcode123 {

    /**
     * 动态规划
     * [i][j][k]
     * i:第几天
     * j:是否持有股票，1 or 0
     * k:交易了几次
     * @param prices
     * @return
     */
    public static int dp(int[] prices, int times) {
        int days = prices.length;
        int[][][] dp = new int[days][2][times + 1];
        for (int i = 0; i < days; ++i) {
            if (i == 0) {
                dp[i][0][0] = 0;
                dp[i][1][0] = -prices[i];
            } else {
                for (int t = 0; t <= times; ++t) {
                    if (t == 0) {
                        dp[i][0][t] = dp[i - 1][0][t];
                        dp[i][1][t] = Integer.max(dp[i - 1][0][t] - prices[i], dp[i - 1][1][t]);
                    } else {
                        dp[i][0][t] = Integer.max(dp[i - 1][0][t], dp[i - 1][1][t - 1] + prices[i]);
                        dp[i][1][t] = Integer.max(dp[i -1][0][t] - prices[i], dp[i -1][1][t]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < days; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k <= times; ++k) {
                    System.out.println(dp[i][j][k]);

                }
            }
        }

        for (int m = 0; m <= times; ++m) {
            if (dp[days - 1][0][m] > max) {
                max = dp[days - 1][0][m];
            }
        }
        return max;
    }



    //递归
    public int maxProfit(int[] prices) {
        int[] res = new int[1];
        cursion(res, prices, 0, 0, 0, Integer.MAX_VALUE);
        return res[0];
    }

    private void cursion(int[] res, int[] prices,int day, int buyTime, int tmpProfit, int minPrice) {
        if (tmpProfit > res[0]) {
            res[0] = tmpProfit;
        }
        if (day >= prices.length || buyTime >= 2) {
            return;
        }
        if (prices[day] < minPrice) {
            minPrice = prices[day];
        }
        //买了
        cursion(res, prices, day + 1, buyTime + 1, tmpProfit + prices[day] - minPrice, Integer.MAX_VALUE);
        //不买
        cursion(res, prices, day + 1, buyTime, tmpProfit, minPrice);
    }
}
