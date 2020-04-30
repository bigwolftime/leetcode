package offer;

/**
 * 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * 统计好频率后, 需要从左向右遍历字符串
 */
public class FirstUniqChar {

    private static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        int[] num = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int x = getIndexByChar(s.charAt(i));
            num[x]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (num[getIndexByChar(s.charAt(i))] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    private static int getIndexByChar(char c) {
        return c >= 97 ? c - 97 : c - 65;
    }

    public static void main(String[] args) {
        firstUniqChar("cc");
    }

}
