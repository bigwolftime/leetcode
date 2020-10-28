package offer;

import java.math.BigDecimal;

/**
 * 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * 大数给爷搞懵了😵
 * 用了 BigDecimal ...
 */
public class NumWays {

    private static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }

        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(2);
        BigDecimal temp = new BigDecimal(a.intValue() + b.intValue());
        for (int i = 3; i <= n; i++) {
            temp = a.add(b);
            a = b;
            b = temp;
        }

        BigDecimal[] arr = temp.divideAndRemainder(BigDecimal.valueOf(1000000007L));
        return arr[1].intValue();
    }

    public static void main(String[] args) {
        numWays(4);
    }

}
