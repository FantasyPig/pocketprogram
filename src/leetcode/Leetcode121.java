package leetcode;

/**
 * 买卖股票
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            int tmp = prices[i] - minPrice;
            if (tmp > res) {
                res = tmp;
            }
        }
        return res;
    }

}
