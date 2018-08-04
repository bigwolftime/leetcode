/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 * 
 * 待解决。。。
 * @author bwt
 *
 */
public class MaxProfit {

	public static int maxProfit(int[] prices) {
		// 出判断一下是否有误
		if (prices.length < 2) {
			return 0;
		}

		// 定义局部变量 low profit
		int low = prices[0];
		int profit = 0;
		for (int i = 1; i != prices.length; ++i) {
			if (prices[i] > low) {
				profit = profit + prices[i] - low;
			}
			low = prices[i];
		}
		return profit; // 注意输出的是什么
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		maxProfit(prices);
	}
}
