package leetcode;

/**
 * 到目标元素的最小距离
 * https://leetcode-cn.com/problems/minimum-distance-to-the-target-element/
 *
 * @author liuxin
 * @date 2021/5/14 15:14
 */
public class GetMinDistance {

    private static int getMinDistance(int[] nums, int target, int start) {
        int abs =Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                abs = Math.min(Math.abs(i - start), abs);
            }
        }

        return abs;
    }

    public static void main(String[] args) {

    }

}
