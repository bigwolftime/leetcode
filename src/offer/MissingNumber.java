package offer;

/**
 * 0 到 n - 1 中缺失的数字, 简单
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class MissingNumber {

    private static int missingNumber(int[] nums) {
        int index = 0;
        for (int i : nums) {
            if (index != i) {
                return index;
            }
            index++;
        }

        return index;
    }

    public static void main(String[] args) {

    }

}
