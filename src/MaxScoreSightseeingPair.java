/**
 * 最佳观光组合
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 *
 * 即计算数组中 公式: A[i] + i + A[j] - j 的最大值
 * 一旦 j 确定, A[j] - j 就不变.
 * 可以在 O(n) 级别计算
 *
 * @author liuxin
 * @time 2020/6/17 9:45
 */
public class MaxScoreSightseeingPair {

    private static int maxScoreSightseeingPair(int[] A) {
        int idx = 1;
        int maxI = 0, max = Integer.MIN_VALUE;

        for (; idx < A.length; idx++) {
            maxI = Math.max(maxI, A[idx - 1] + idx - 1);
            max = Math.max(max, maxI + A[idx] - idx);
        }

        return max;
    }

    public static void main(String[] args) {
        System.err.println(maxScoreSightseeingPair(new int[]{2,2,2}));
    }

}
