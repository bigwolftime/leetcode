package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/
 *
 * 贪心.
 * 思路: 已知第一个字符位置 idx, 查看这个字符最后出现的位置 lastIdx, 然后看 [idx, lastIdx] 之间的字符是否最后出现位置, 是否都在此区间,
 *      超出区间的话更新 lastIdx.
 *
 *      使用一个 list 数组, 存储每个字符出现的位置信息
 *
 * @author liuxin
 * @time 2020/10/22 10:01
 */
public class PartitionLabels {

    private static List<Integer>[] posArr;

    private static List<Integer> partitionLabels(String S) {
        posArr = new ArrayList[26];
        char c;
        List<Integer> list;

        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            list = posArr[c - 97];

            if (list == null) {
                list = new ArrayList<>();
                posArr[c - 97] = list;
            }

            list.add(i);
        }

        List<Integer> resList = new ArrayList<>();
        int idx = 0;

        while (idx < S.length()) {
            // 判断 [idx, lastIdx] 之间的最后字符都在此区间
            int lastIdx = determineRange(idx, S);
            resList.add(lastIdx - idx + 1);

            idx = lastIdx + 1;
        }

        return resList;
    }

    /**
     * 计算区间
     * @param idx
     * @param S
     * @return
     */
    private static int determineRange(int idx, String S) {
        List<Integer> list = posArr[S.charAt(idx) - 97];
        int lastIdx = list.get(list.size() - 1);

        for (; idx <= lastIdx; idx++) {
            list = posArr[S.charAt(idx) - 97];
            lastIdx = Math.max(lastIdx, list.get(list.size() - 1));
        }

        return lastIdx;
    }

    public static void main(String[] args) {
        System.err.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

}
