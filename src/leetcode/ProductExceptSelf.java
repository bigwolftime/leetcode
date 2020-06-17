package leetcode;

/**
 * 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * @author liuxin
 * @time 2020/6/4 10:23
 */
public class ProductExceptSelf {

    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] lArr = new int[len];
        int[] rArr = new int[len];

        lArr[0] = 1;
        rArr[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            // 构造 左右乘积列表
            lArr[i] = lArr[i - 1] * nums[i - 1];
            rArr[len - 1 - i] = rArr[len - i] * nums[len - i];
        }

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = lArr[i] * rArr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{4, 5, 1, 8, 2});
    }

}
