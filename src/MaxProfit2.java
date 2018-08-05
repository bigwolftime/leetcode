/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 * 
 * @author bwt
 *
 *	思路：
 *	参考：https://blog.csdn.net/chenvast/article/details/78950392
 *	与 I 不同，没有限制交易次数，即只要挣钱就卖出。
 *
 *	时间复杂度：O(N)
 *	空间复杂度：O(1)
 */
public class MaxProfit2 {

	public static int maxProfit(int[] prices) {
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
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.err.println(maxProfit(prices));
	}
}
