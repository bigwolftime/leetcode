package leetcode;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 *	思路：
 *	参考：https://blog.csdn.net/chenvast/article/details/78950392
 *	与 I 不同，没有限制交易次数，即只要挣钱就卖出。
 *
 *	时间复杂度：O(N)
 *	空间复杂度：O(1)
 *
 * @author liuxin
 * @date 2020/11/8 17:28
 */
public class MaxProfitII {

    private static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int max = 0, temp = 0;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i] - prices[i - 1];

            if (temp > 0)
                max += temp;
        }

        return max;
    }

    public static void main(String[] args) {

    }

}
