package leetcode;

/**
 * 统计位数为偶数的数字
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 *
 * @author liuxin
 * @time 2020/10/23 15:07
 */
public class FindNumbers {

    private static int findNumbers(int[] nums) {
        int count = 0;
        int curCount;

        for (int val : nums) {
            curCount = 0;

            while (val != 0) {
                val /= 10;
                curCount++;
            }

            if ((curCount & 1) == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
