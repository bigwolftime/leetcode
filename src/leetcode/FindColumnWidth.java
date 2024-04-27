package leetcode;

import java.util.Arrays;

/**
 * 查询网格中每一列的宽度<br/>
 * <a href="https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid">...</a>
 *
 * @author liuxin
 * @date 2024/4/27 11:21
 */
public class FindColumnWidth {

    private static int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];

        for (int[] ints : grid) {
            for (int i = 0; i < ints.length; i++) {
                int val = ints[i];
                ans[i] = Math.max(ans[i], getLen(val));
            }
        }

        return ans;
    }

    private static int getLen(int val) {
        int len = val > 0 ? 0 : 1;
        while (val != 0) {
            val /= 10;
            len++;
        }

        return len;
    }


    public static void main(String[] args) {
        int[] columnWidth = findColumnWidth(new int[][]{
                {1   , 2},
                {22,   6666},
                {333, 22}
        });
        Arrays.stream(columnWidth).forEach(System.err::println);
    }

}
