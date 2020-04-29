package offer;

/**
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * 买卖股票的最佳时机
 */
public class MaxProfit {

    private static int maxProfit(int[] prices) {
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
        int[] nums = new int[]{ 7,1,5,3,6,4 };
        System.err.println(maxProfit(nums));
    }

}
