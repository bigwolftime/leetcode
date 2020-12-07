package leetcode;

/**
 * 连续字符
 * https://leetcode-cn.com/problems/consecutive-characters/
 */
public class MaxPower {

    private static int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxCount = 1;
        int curCount = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 >= s.length()) {
                break;
            }

            if (s.charAt(i) == s.charAt(i + 1)) {
                curCount++;
            } else {
                maxCount = Math.max(maxCount, curCount);
                curCount = 1;
            }
        }

        return Math.max(maxCount, curCount);
    }

    public static void main(String[] args) {
        System.err.println(maxPower("cc"));
    }

}
