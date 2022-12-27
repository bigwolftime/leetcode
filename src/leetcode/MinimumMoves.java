package leetcode;

/**
 * 转换字符串的最少操作次数
 * https://leetcode.cn/problems/minimum-moves-to-convert-string/
 *
 * @author liuxin
 * @date 2022/12/27 6:21 PM
 */
public class MinimumMoves {

    private static int minimumMoves(String s) {
        int idx = 0;
        int cnt = 0;

        while (idx < s.length()) {
            char c = s.charAt(idx);

            if (c == 'O') {
                idx++;
                continue;
            }

            cnt++;
            idx += 3;
        }

        return cnt;
    }


    public static void main(String[] args) {
        minimumMoves("XXOX");
    }

}
