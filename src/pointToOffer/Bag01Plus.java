package pointToOffer;

public class Bag01Plus {

    /**
     * 动态规划解决01背包
     * @param weight 物品质量
     * @param n 物品个数
     * @param w 背包可承载重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] c = new boolean[n][w + 1];
        c[0][0] = true;
        c[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= w; ++j) {
                if (c[i - 1][j] == true) {
                    c[i][j] = c[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (c[i - 1][j] == true) {
                    c[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >=0; --i) {
            if (c[n-1] [i] == true) {
                return i;
            }
        }
        return 0;
    }


}
