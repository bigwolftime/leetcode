package leetcode;

/**
 * K 进制表示下的各位数字总和
 * https://leetcode.cn/problems/sum-of-digits-in-base-k/
 *
 * 除 k 取余
 *
 * @author liuxin
 * @date 2022/10/9 17:22
 */
public class SumBase {

    private static int sumBase(int n, int k) {
        int sum = 0;
        while (n >= k) {
            int div = n / k;
            sum += n % k;
            n = div;
        }
        sum += n;

        return sum;
    }


    public static void main(String[] args) {
        sumBase(500, 8);
    }

}
