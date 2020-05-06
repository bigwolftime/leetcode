package offer;

/**
 * 青蛙跳台台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * 最终优化版
 */
public class NumWays {

    private static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n % 1000000007;
        }

        long a = 1, b = 2;
        long temp = a + b;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return (int) (temp % 1000000007L);
    }

    public static void main(String[] args) {
        numWays(4);
    }

}
