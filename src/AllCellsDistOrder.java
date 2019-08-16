import java.util.Arrays;
import java.util.Comparator;

/**
 * 距离顺序排列矩阵单元格
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 *
 * 没看懂排列的顺序是什么意思？
 * @author Liuxin
 * @since 2019/8/16 14:59
 */
public class AllCellsDistOrder {

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int index = 0;

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                res[index][0] = Math.abs(r - r0);
                res[index][1] = Math.abs(c - c0);
                index++;
            }
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int tmp1 = o1[0] + o1[1];
                int tmp2 = o2[0] + o2[1];

                return tmp1 - tmp2;
            }
        });

        return res;
    }

    public static void main(String[] args) {
        int[][] res = allCellsDistOrder(2, 3, 1, 2);
        for (int[] arr : res){
            System.err.println(arr[0] + ", " + arr[1]);
        }
    }
}
