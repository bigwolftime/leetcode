package leetcode;

/**
 * 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * 不转化为字符串
 * 反序相加, 看最后的结果是否相同
 *
 * @author liuxin
 * @time 2020/6/10 10:39
 */
public class isPalindromeNum {

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int sum = 0;
        int temp = x;

        do {
            sum = sum * 10 + x % 10;
            x /= 10;
        } while (x != 0);

        return sum == temp;
    }

    public static void main(String[] args) {
        System.err.println(isPalindrome(999999998));
    }

}
