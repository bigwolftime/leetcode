/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/c
 * 原地算法有点问题没有解决。目前使用暴力复制。
 *
 * @author Liuxin
 * @since 2019/9/5 10:23
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] tmp = new int[len];
        int nextIdx = (0 + (len - k)) % len;

        for (int i = 0; i < tmp.length; i++){
            tmp[i] = nums[nextIdx];
            nextIdx++;
            nextIdx = nextIdx % len;
        }

        for (int i = 0; i < len; i++){
            nums[i] = tmp [i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotate(nums, 2);

        //System.err.println(-2 % 5);
    }
}
