package offer;

/**
 * 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author liuxin
 * @date 2020/7/22 7:40
 */
public class MinArray {

    private static int minArray(int[] numbers) {
        // O(n)
        int last = Integer.MIN_VALUE;

        for (int i : numbers) {
            if (i < last) {
                return i;
            }
            last = i;
        }

        return numbers[0];
    }

    public static void main(String[] args) {
        System.err.println(minArray(new int[]{ 1,3,5 }));
    }

}
