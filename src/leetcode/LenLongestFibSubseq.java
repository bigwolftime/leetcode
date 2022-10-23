package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长的斐波那契子序列的长度
 * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 *
 * 定义:
 * dp[i][j] 存储以索引 i 开始, 索引 j 结束的最长子序列的长度
 *
 * 在索引 i 之前, 假设有索引 k, 使: arr[k] + arr[i] = arr[j] 成立, 则 dp[i][j] = dp[k][i] + 1
 * 其中: 数组 dp 中元素的最小值为 2
 *
 * @author liuxin
 * @date 2022/7/9 11:24 PM
 */
public class LenLongestFibSubseq {

    private static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }


        int size = arr.length;
        int[][] dp = new int[size][size];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                Integer k = map.get(diff);
                if (k == null || k >= i) {
                    continue;
                }

                if (dp[k][i] == 0) {
                    dp[k][i] = 2;
                }

                dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        lenLongestFibSubseq(new int[]{ 1,2,3,4,5,6,7,8 });
    }

}
