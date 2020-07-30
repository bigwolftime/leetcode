package lcci;

/**
 * 魔术索引
 * https://leetcode-cn.com/problems/magic-index-lcci/
 *
 * @author liuxin
 * @date 2020/7/31 7:21
 */
public class FindMagicIndex {

    private static int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}
