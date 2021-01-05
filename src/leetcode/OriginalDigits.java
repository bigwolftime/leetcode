package leetcode;

/**
 * 从英文中重建数字
 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/
 *
 * 1 “z” 只在 “zero” 中出现。
 *   “w” 只在 “two” 中出现。
 *   “u” 只在 “four” 中出现。
 *   “x” 只在 “six” 中出现。
 *   “g” 只在 “eight” 中出现。
 *
 * 2 在剩下的字符中
 *   “h” 在 “three” 中出现。
 *   “f” 在 “five” 中出现。
 *   “s” 在 “seven”中出现。
 *
 * 3. “i” 在 “nine” 中出现。
 *    “n” 在 “one” 中出现。
 *
 */
public class OriginalDigits {

    private static int[] countArr;
    private static int[] statArr;


    private static String originalDigits(String s) {
        statArr = new int[10];
        countArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countArr[s.charAt(i) - 97]++;
        }

        calcZWUXG();
        calcHFS();
        calcNI();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < statArr.length; i++) {
            int cnt = statArr[i];

            while (cnt-- > 0) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    /**
     * 调用优先级 1
     */
    private static void calcZWUXG() {
        match('z', new char[]{ 'e', 'r', 'o' }, 0);
        match('w', new char[]{ 't', 'o' }, 2);
        match('u', new char[]{ 'f', 'o', 'r' }, 4);
        match('x', new char[]{ 's', 'i' }, 6);
        match('g', new char[]{ 'e', 'i', 'h', 't' }, 8);
    }

    /**
     * 调用优先级 2
     */
    private static void calcHFS() {
        match('h', new char[]{ 't', 'r', 'e', 'e' }, 3);
        match('f', new char[]{ 'i', 'v', 'e' }, 5);
        match('s', new char[]{ 'e', 'v', 'e', 'n' }, 7);
    }

    /**
     * 调用优先级 3
     */
    private static void calcNI() {
        match('i', new char[]{ 'n', 'n', 'e' }, 9);
        match('n', new char[]{ 'o', 'e' }, 1);
    }

    private static void match(char cFlag, char[] otherChar, int val) {
        int idx = cFlag - 97;
        int cnt = countArr[idx];
        if (cnt == 0) {
            return;
        }

        statArr[val] += cnt;

        countArr[idx] = 0;
        for (char c : otherChar) {
            countArr[c - 97] -= cnt;
        }
    }


    public static void main(String[] args) {

    }

}
