package leetcode;

/**
 * 移除石子的最大得分
 * https://leetcode.cn/problems/maximum-score-from-removing-stones/
 *
 * 贪心
 *
 * @author liuxin
 * @date 2022/12/21 10:08 PM
 */
public class MaximumScore {

    private static int maximumScore(int a, int b, int c) {
        if (!isValid(a, b, c)) {
            return 0;
        }

        int cnt = 0;

        do {
            if (a <= b && a <= c) {
                // min a
                b--;
                c--;
                cnt++;
            } else if (b <= a && b <= c) {
                // min b
                a--;
                c--;
                cnt++;
            } else {
                // min c
                a--;
                b--;
                cnt++;
            }

        } while (isValid(a, b, c));


        return cnt;
    }

    private static boolean isValid(int a, int b, int c) {
        return (a > 0 && b > 0) || (a > 0 && c > 0) || (b > 0 && c > 0);
    }


    public static void main(String[] args) {

    }

}
