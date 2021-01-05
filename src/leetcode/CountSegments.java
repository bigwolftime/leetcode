package leetcode;

/**
 * 字符串中的单词数
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 */
public class CountSegments {

    private static int countSegments(String s) {
        int count = 0;

        int idx = 0;
        while (idx < s.length()) {
            boolean flag = false;

            while (idx < s.length() && s.charAt(idx) == ' ') {
                // 找到不是空格的字符
                idx++;
            }

            while (idx < s.length() && s.charAt(idx) != ' ') {
                flag = true;
                idx++;
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
