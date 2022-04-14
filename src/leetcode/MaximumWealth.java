package leetcode;

/**
 * 最富有客户的资产总量
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 *
 * @author imacbook
 * @date 2022/4/14 9:15 PM
 */
public class MaximumWealth {

    private static int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] account : accounts) {
            int curMax = 0;

            for (int i : account) {
                curMax += i;
            }

            max = Math.max(max, curMax);
        }

        return max;
    }

    public static void main(String[] args) {


    }

}
