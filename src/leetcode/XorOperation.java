package leetcode;

/**
 * 数组异或操作
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 *
 * lcp 194 第一题
 *
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 *
 * @author liuxin
 * @date 2020/6/21 10:31
 *
 * 1. 直接使用循环的方法, 时间复杂度 O(n);
 * 2. 找规律: 2^3 = 1, 4^5 = 1... 时间复杂度 O(1)
 */
public class XorOperation {

    private static int xorOperation(int n, int start) {
        /*if ((n & 1) == 0) {
            // wrong
            return start & 8;
        }

        return (start & 8) ^ ((start + 2 * (n - 1)) & 8);*/

        if (n == 0) {
            return 0;
        }

        int res = start;

        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.err.println(xorOperation(4,3));
    }

}
