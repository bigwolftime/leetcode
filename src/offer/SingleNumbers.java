package offer;

/**
 * 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * 一个数组: 有 2 个数字出现了 1 次, 其余均出现了 2 次, 求这 2 个数字
 *
 */
public class SingleNumbers {

    private static int[] singleNumbers(int[] nums) {
        // 所有数字进行一次异或
        int xorRes = 0;
        for (int i : nums) {
            xorRes ^= i;
        }

        int div = 1;
        while ((div & xorRes) == 0) {
            div <<= 1;
        }

        // 分组
        int xorA = 0, xorB = 0;
        for (int i : nums) {
            if ((i & div) == 0) {
                xorB ^= i;
            } else {
                xorA ^= i;
            }
        }

        return new int[]{ xorA, xorB };
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 4, 2, 4, 6 };
        int[] res = singleNumbers(nums);
    }

}
