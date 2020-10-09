package leetcode;

/**
 * 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author liuxin
 * @date 2020/10/8 8:51
 */
public class ReverseString {

    private static void reverseString(char[] s) {
        int p = 0, q = s.length - 1;
        char c;

        while (p < q) {
            c = s[p];
            s[p] = s[q];
            s[q] = c;

            p++;
            q--;
        }
    }

    public static void main(String[] args) {

    }

}
