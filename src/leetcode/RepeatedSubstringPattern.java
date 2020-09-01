package leetcode;

/**
 * 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @author liuxin
 * @date 2020/8/31 16:06
 */
public class RepeatedSubstringPattern {

    private static boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < (s.length() >> 1); i++) {
            boolean flag = true;
            sb.append(s.charAt(i));

            if (s.length() % sb.length() != 0) {
                // 长度不能整除 -> continue
                continue;
            }

            for (int j = sb.length(); j < s.length(); j += sb.length()) {
                if (!sb.toString().equals(s.substring(j, j + sb.length()))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.err.println(repeatedSubstringPattern("a"));
    }

}
