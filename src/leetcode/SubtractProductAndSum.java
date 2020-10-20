package leetcode;

/**
 * 整数的各位积和之差
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * @author liuxin
 * @time 2020/10/20 14:29
 */
public class SubtractProductAndSum {

    private static int subtractProductAndSum(int n) {
        int integrate = 1, sum = 0;

        while (n != 0) {
            int temp = n % 10;

            integrate *= temp;
            sum += temp;

            n /= 10;
        }

        return integrate - sum;
    }

    public static void main(String[] args) {

    }

}
