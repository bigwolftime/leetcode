package leetcode;

/**
 * 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author liuxin
 * @date 2020/7/27 22:52
 */
public class IsSubsequence {

    private static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return false;
        }


        int p = 0, q = 0;
        while (p < s.length() && q < t.length()) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
            }
            q++;
        }

        return p == s.length();
    }

    public static void main(String[] args) {
        System.err.println(isSubsequence("", "ahbgdc"));
    }

}
