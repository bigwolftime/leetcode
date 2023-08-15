package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的查找与替换
 * https://leetcode.cn/problems/find-and-replace-in-string
 *
 * 题目讲究同时替换, 不能影响索引
 *
 * @author liuxin
 * @date 2023/8/15 15:54
 */
public class FindReplaceString {

    private static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();

        for (int i = 0; i < indices.length; i++) {
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            String source = sourceMap.get(idx);
            if (!isMatch(s, idx, source)) {
                sb.append(s.charAt(idx));
                idx++;
                continue;
            }

            sb.append(targetMap.get(idx));
            idx += source.length();
        }

        return sb.toString();
    }

    private static boolean isMatch(String s, int idx, String matchS) {
        if (matchS == null) {
            return false;
        }

        if (matchS.length() > s.length() - idx) {
            // 超长了
            return false;
        }

        int matchIdx = 0;
        for (; idx < s.length(); idx++, matchIdx++) {
            if (matchIdx >= matchS.length()) {
                return true;
            }

            if (s.charAt(idx) != matchS.charAt(matchIdx)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        /**
         * s =
         * "abcd"
         * indices =
         * [0, 2]
         * sources =
         * ["a", "cd"]
         * targets =
         * ["eee", "ffff"]
         */
        findReplaceString("abcd", new int[]{ 0,2 }, new String[]{ "a", "cd"}, new String[]{ "eee","fff" });
    }

}
