package leetcode;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 我太蠢了 fk
 *
 * @author liuxin
 * @time 2020/6/28 15:05
 */
public class CanJump {

    private static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        int maxIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            maxIdx = Math.max(nums[i] + i, maxIdx);

            if (maxIdx == i) {
                // 最远距离与 i 相同, 说明没动.
                return false;
            }

            if (maxIdx + 1 >= nums.length) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.err.println(canJump(new int[]{ 2,0,0 }));
    }

}
