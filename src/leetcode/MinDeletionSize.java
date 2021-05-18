package leetcode;

/**
 * 删列造序
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 */
public class MinDeletionSize {

    private static int minDeletionSize(String[] strs) {
        if (strs.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < strs[0].length(); i++) {
            char lastChar = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                char curChar = strs[j].charAt(i);

                if (curChar < lastChar) {
                    count++;
                    break;
                } else {
                    lastChar = curChar;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        minDeletionSize(new String[]{ "rrjk","furt","guzm" });
    }

}
