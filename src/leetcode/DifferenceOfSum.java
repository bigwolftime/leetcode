package leetcode;

/**
 * 数组元素和与数字和之差
 * https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array/
 *
 * @author liuxin
 * @date 2024/9/26 09:58
 */
public class DifferenceOfSum {

    private static int differenceOfSum(int[] nums) {
        int sum = 0;
        int eleSum = 0;

        for (int num : nums) {
            sum += num;


            while (num != 0) {
                int curEle = num % 10;
                eleSum += curEle;
                num /= 10;
            }
        }

        return Math.abs(eleSum - sum);
    }


    public static void main(String[] args) {

    }

}
