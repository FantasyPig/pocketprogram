package leetcode;

/**
 * 零钱兑换
 */
public class Leetcode322 {

    public static void main(String[] args) {
        int[] list = {1,2,5};
        int result = coinChange(list, 11);
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] results = new int[amount + 1];
        for (int i = 0; i < amount + 1; ++i) {
            results[i] = amount + 1;
        }
        results[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j : coins) {
                if (i - j >= 0) {
                    results[i] = Integer.min(results[i - j] + 1, results[i]);
                }
            }
        }
        return results[amount] > amount ? -1 : results[amount];
    }
}
