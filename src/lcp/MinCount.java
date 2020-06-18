package lcp;

/**
 * 拿硬币
 * https://leetcode-cn.com/problems/na-ying-bi/
 *
 * @author liuxin
 * @time 2020/6/18 16:23
 */
public class MinCount {

    private static int minCount(int[] coins) {
        int count = 0;
        boolean redundancy;
        for (int coin : coins) {
            redundancy = coin % 2 == 1;
            count += (coin >> 1);

            if (redundancy) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
