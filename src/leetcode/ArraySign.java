package leetcode;

/**
 * 数组元素积的符号
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 *
 * @author liuxin
 * @date 2022/10/27 10:40 PM
 */
public class ArraySign {

    private static int arraySign(int[] nums) {
        int cntNeNum = 0;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }

            if (num < 0) {
                cntNeNum++;
            }
        }

        return (cntNeNum & 1) == 0 ? 1 : -1;
    }


    public static void main(String[] args) {

    }

}
