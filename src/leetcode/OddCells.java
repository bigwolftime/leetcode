package leetcode;

/**
 * 奇数值单元格的数目
 * https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/
 */
public class OddCells {

    private static int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];

        for (int[] tempArr : indices) {
            int row = tempArr[0], column = tempArr[1];

            for (int i = 0; i < m; i++) {
                arr[row][i]++;
            }
            for (int i = 0; i < n; i++) {
                arr[i][column]++;
            }
        }

        int oddCount = 0;
        for (int[] tempArr : arr) {
            for (int val : tempArr) {
                if ((val & 1) != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }

    public static void main(String[] args) {
        oddCells(2, 3, new int[][]{
                {0,1},
                {1,1}
        });
    }

}
