package leetcode;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author liuxin
 * @time 2020/10/23 15:23
 */
public class LongestPalindrome {

    private static String longestPalindrome(String s) {
        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            StringBuilder gapSb = new StringBuilder();

            StringBuilder indexSb = new StringBuilder();
            indexSb.append(s.charAt(i));

            // gap 扩展 / 索引扩展
            int gapL = i - 1, gapR = i;
            int idxL = i - 1, idxR = i + 1;
            boolean gapFlag = true, idxFlag = true;
            while (gapFlag || idxFlag) {

                if (gapFlag) {
                    if (gapL < 0 || gapR >= s.length()) {
                        gapFlag = false;
                        continue;
                    }

                    char gapLChar = s.charAt(gapL);
                    char gapRChar = s.charAt(gapR);

                    if (gapLChar == gapRChar) {
                        gapSb.insert(0, gapLChar);
                        gapSb.append(gapRChar);
                    } else {
                        gapFlag = false;
                        continue;
                    }

                    gapL--;
                    gapR++;
                }

                if (idxFlag) {
                    if (idxL < 0 || idxR >= s.length()) {
                        idxFlag = false;
                        continue;
                    }
                    char idxLChar = s.charAt(idxL);
                    char idxRChar = s.charAt(idxR);

                    if (idxLChar == idxRChar) {
                        indexSb.insert(0, idxLChar);
                        indexSb.append(idxRChar);
                    } else {
                        idxFlag = false;
                        continue;
                    }

                    idxL--;
                    idxR++;
                }

            }

            if (gapSb.length() > longestPalindrome.length()) {
                longestPalindrome = gapSb.toString();
            }
            if (indexSb.length() > longestPalindrome.length()) {
                longestPalindrome = indexSb.toString();
            }
        }

        return longestPalindrome;
    }

    public static void main(String[] args) {
        System.err.println(longestPalindrome("babad"));
    }

}
