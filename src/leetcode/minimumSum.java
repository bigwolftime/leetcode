package leetcode;

import javafx.util.Pair;

/**
 * 元素和最小的山行三元组I<br/>
 * <a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i">...</a>
 * <br/>
 * i, j, k 不一定要连续
 *
 * @author liuxin
 * @date 2024/3/29 16:26
 */
public class minimumSum {

    private static int minimumSum(int[] nums) {
        int sum = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    Pair<Boolean, Integer> mountainPair = isMountain(nums, i, j, k);
                    if (mountainPair.getKey()) {
                        sum = Math.min(sum, mountainPair.getValue());
                        flag = true;
                    }

                }
            }
        }

        return flag ? sum : -1;
    }

    /**
     * 判断是否为 mountain, 是则返回 sum
     * @param nums
     * @return
     */
    private static Pair<Boolean, Integer> isMountain(int[] nums, int i, int j, int k) {
        int iVal = nums[i];
        int jVal = nums[j];
        int kVal = nums[k];

        boolean isMountain = iVal < jVal && jVal > kVal;
        return isMountain ? new Pair<>(true, iVal + jVal + kVal) : new Pair<>(false, 0);
    }


    public static void main(String[] args) {
        // 5, 4, 8, 7, 10, 2
        System.err.println(Integer.MAX_VALUE);
    }

}
