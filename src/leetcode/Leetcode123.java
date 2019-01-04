package leetcode;

/**
 * 121,122,123,309,188,714.
 * 股票买卖
 * way 1 : cursion
 * way 2 : dp (so difficult)
 */
public class Leetcode123 {

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
