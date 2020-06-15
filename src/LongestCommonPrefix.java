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
        StringBuilder res = new StringBuilder();

        if (strs.length == 0 || strs[0].isEmpty()){
            return res.toString();
        }

        int index = 0;
        char c;
        while (true) {
            if (index >= strs[0].length()) {
                return res.toString();
            }

            c = strs[0].charAt(index);
            for (String str : strs) {
                if (index >= str.length() || str.charAt(index) != c) {
                    return res.toString();
                }
            }

            res.append(c);
            index++;
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cab", "ab"};
        System.err.println(longestCommonPrefix(strs));
    }
}
