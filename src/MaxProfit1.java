/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author bwt
 *
 *	参考：https://blog.csdn.net/chenvast/article/details/78950392
 *	思路：
 *	首先遍历数组，将当天与上一天利益进行做差，将利益值存入新数组；
 *	声明两个变量 max 和 temp，首先确保 temp + i > 0，即有收益，那么计算收益，否则
 *不买进股票，即收益为 0，每次 max 最大的值，最后的结果就是 max。
 *	时间复杂度：O(N)，空间复杂度：O(1)
 */
public class MaxProfit1 {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
			
		int[] changeList = new int[prices.length - 1];
		for(int i = 1; i < prices.length; i++) {
			changeList[i - 1] = prices[i] - prices[i - 1];
		}
		
		int max = 0, temp = 0;
		for (int i : changeList) {
			if (temp + i > 0)
				temp += i;
			else
				temp = 0;
			max = Math.max(max, temp);
		}
		
        return max;
    }
	
	public static void main(String[] args) {
		int[] prices = new int[] {};
		System.err.println(maxProfit(prices));
	}
}
