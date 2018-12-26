package pointToOffer;

/**
 * 01背包问题
 * method 1、回溯算法
 * 优化： 将f(i, cw)存到map，达到剪纸的效果
 */
public class Bag01 {

    private int maxW = Integer.MAX_VALUE; // 结果放到maxW
    private int[] weight = {2, 2, 4, 6, 3}; // 物品重量
    private int n = 5; // 物品数量
    private int w = 9; // 背包承受的重量
    public void f(int i, int cw) {
        if (cw == w || i == n) {
            if (maxW < cw) {
                maxW  = cw;
            }
            return;
        }
        f(i + 1, cw);
        if (weight[ i + 1] + cw <= w) {
            f(i + 1, cw + weight[i + 1]);
        }
    }

}
