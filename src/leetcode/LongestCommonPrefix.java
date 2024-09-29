package leetcode;

import javafx.util.Pair;

/**
 * @Author Liuxin
 * @Date 2019/3/26 16:17
 *
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/submissions/
 *
 * 思路：一种纵向扫描，从下标 0 开始，遍历每个字符串，直到遇到不相同的字符串
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            boolean eq = eq(strs, index);
            if (!eq) {
                break;
            }

            sb.append(strs[0].charAt(index));
            index++;
        }

        return sb.toString();
    }

    private static boolean eq(String[] strs, int index) {
        if (index >= strs[0].length()) {
            return false;
        }

        char c = strs[0].charAt(index);

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (index >= str.length()) {
                return false;
            }

            char c_tmp = str.charAt(index);
            if (c_tmp != c) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cab", "ab"};
        System.err.println(longestCommonPrefix(strs));
        Pair pair = new Pair(0, 1);
        pair.getValue();

    }
}
