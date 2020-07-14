package leetcode;

import java.util.Random;

/**
 * 随机数索引
 * https://leetcode-cn.com/problems/random-pick-index/
 *
 * 新学了一个类型题 - 蓄水池抽样.
 * https://en.wikipedia.org/wiki/Reservoir_sampling
 *
 * @author liuxin
 * @time 2020/7/14 17:27
 */
public class Pick {

    private int[] nums;

    public Pick(int[] nums) {
        this.nums = nums;
    }

    private int pick(int target) {
        int baseIndex = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (new Random().nextInt() % count == 0) {
                    baseIndex = i;
                }
            }
        }

        return baseIndex;
    }

    public static void main(String[] args) {
        Pick pick = new Pick(new int[]{1, 2, 3, 3, 3});

        for (int i = 0; i < 5000000; i++) {
            pick.pick(3);
        }
    }

}
