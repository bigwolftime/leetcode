package leetcode;

import java.util.HashSet;

/**
 * 视频拼接
 * https://leetcode-cn.com/problems/video-stitching/
 *
 * 贪心策略
 *
 * @author liuxin
 * @date 2020/10/24 10:39
 */
public class VideoStitching {

    private static int videoStitching(int[][] clips, int T) {
        HashSet<Integer> set = new HashSet<>();
        int minMin = 0, minMax = 0;
        int max = 0;
        int maxIdx = -1;

        boolean flag;

        while (max < T) {
            flag = false;
            int[] arr;

            for (int i = 0; i < clips.length; i++) {
                if (set.contains(i)) {
                    // 已经用过
                    continue;
                }

                arr = clips[i];
                if (arr[0] >= minMin && arr[0] <= minMax) {
                    if (maxIdx == -1 || arr[1] > clips[maxIdx][1]) {
                        // 符合起止区间 -> 记录索引
                        maxIdx = i;
                        flag = true;
                    }
                }
            }

            if (!flag) {
                // 缺少片段 无法剪辑
                return -1;
            }

            arr = clips[maxIdx];

            minMin = arr[0] + 1;
            minMax = arr[1];
            max = arr[1];
            set.add(maxIdx);
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[][] clips = new int[][]{
                { 0,2 },
                { 4,6 },
                { 8,10 },
                { 1,9 },
                { 1,5 },
                { 5,9 }
        };
        videoStitching(clips, 10);
    }

}
