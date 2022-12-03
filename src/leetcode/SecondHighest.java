package leetcode;

/**
 *
 * 字符串中第二大的数字
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 *
 * @author liuxin
 * @date 2022/12/3 9:26 PM
 */
public class SecondHighest {


    private static int secondHighest(String s) {
        int maxVal = -1, secVal = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!isDigital(c)) {
                continue;
            }

            int val = c - 48;

            if (val < secVal) {
                continue;
            }


            if (val > maxVal) {
                secVal = maxVal;
                maxVal = val;
            } else if (val > secVal && val < maxVal) {
                secVal = val;
            }
        }

        return secVal;
    }

    private static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }


    public static void main(String[] args) {

    }

}
