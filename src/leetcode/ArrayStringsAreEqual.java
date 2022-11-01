package leetcode;

/**
 * 检查两个字符串数组是否相等
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 *
 * @author liuxin
 * @date 2022/11/1 13:18
 */
public class ArrayStringsAreEqual {

    private static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int p = 0, q = 0;
        int i = 0, j = 0;

        while (p < word1.length && q < word2.length) {
            String s1 = word1[p];
            String s2 = word2[q];

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                return false;
            }

            i++;
            j++;

            if (i == s1.length()) {
                p++;
                i = 0;
            }
            if (j == s2.length()) {
                q++;
                j = 0;
            }
        }

        while (p < word1.length) {
            String s1 = word1[p];
            String s2 = word2[word2.length - 1];

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                return false;
            }

            if (i == s1.length()) {
                p++;
                i = 0;
            } else {
                i++;
            }
        }

        while (q < word2.length) {
            String s1 = word1[word1.length - 1];
            String s2 = word2[q];

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                return false;
            }

            if (j == s2.length()) {
                q++;
                j = 0;
            } else {
                j++;
            }
        }

        return p == word1.length && q == word2.length && i == 0 && j == 0;
    }

    public static void main(String[] args) {
        boolean b = arrayStringsAreEqual(new String[]{"hel", "lo"}, new String[]{"h", "e", "llo"});
        System.err.println(b);
    }

}
