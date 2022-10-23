package leetcode;

/**
 * 交替合并字符串
 * https://leetcode.cn/problems/merge-strings-alternately/
 *
 * @author liuxin
 * @date 2022/10/23 9:29 AM
 */
public class MergeAlternately {


    private static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int p = 0, q = 0;

        while (p < word1.length() && q < word2.length()) {
            sb.append(word1.charAt(p)).append(word2.charAt(q));
            p++;
            q++;
        }

        while (p < word1.length()) {
            sb.append(word1.charAt(p++));
        }
        while (q < word2.length()) {
            sb.append(word2.charAt(q++));
        }

        return sb.toString();
    }


    public static void main(String[] args) {

    }

}
