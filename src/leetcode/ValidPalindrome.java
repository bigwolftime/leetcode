package leetcode;

/**
 * 验证回文字符串II
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 * @author liuxin
 * @time 2020/5/19 14:13
 */
public class ValidPalindrome {

    private static boolean validPalindrome(String s) {
        boolean validRes = valid(s, true);

        if (!validRes) {
            validRes = valid(s, false);
        }

        return validRes;
    }

    private static boolean valid(String s, boolean b) {
        int p = 0, q = s.length() - 1;
        boolean flag = true;

        while (p < q) {
            if (s.charAt(p) == s.charAt(q)) {
                p++;
                q--;
            } else {
                if (!flag) {
                    return false;
                }

                flag = false;
                // 注意此处的优先级, 凭什么先判断 p + 1 ?
                // lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul
                // 所以如果为 false 则再判断一遍
                if (b && s.charAt(p + 1) == s.charAt(q)) {
                    p++;
                } else if (s.charAt(p) == s.charAt(q - 1)) {
                    q--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.err.println(validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
    }

}
