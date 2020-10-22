package lcci;

/**
 * 阶乘尾数
 * https://leetcode-cn.com/problems/factorial-zeros-lcci/
 *
 * Fuck LeetCode
 *
 * @author liuxin
 * @time 2020/10/22 14:17
 */
public class TrailingZeroes {

    private static int trailingZeroes(int n) {
        int count = 0;

        while (n != 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        System.err.println(trailingZeroes(1808548329));
    }

}
