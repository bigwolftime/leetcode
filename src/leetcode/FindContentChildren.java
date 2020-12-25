package leetcode;

import java.util.Arrays;

/**
 * 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class FindContentChildren {

    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int p = 0, q = 0;
        while (p < g.length && q < s.length) {
            if (g[p] <= s[q]) {
                // 可以满足
                count++;
                p++;
            }

            q++;
        }

        return count;
    }


    public static void main(String[] args) {
        findContentChildren(new int[]{ 10,9,8,7 }, new int[]{ 5,6,7,8 });
    }

}
