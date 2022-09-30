package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以攻击国王的皇后
 * https://leetcode.cn/problems/queens-that-can-attack-the-king/
 *
 * 把 queens 数组和 king 转成完整的棋盘数据, 方便判断
 * @author liuxin
 * @date 2022/9/30 3:11 PM
 */
public class QueensAttacktheKing {

    private static List<List<Integer>> ATTACK_POINT_LIST;

    private static final int QUEEN = 2;
    private static final int KING = 1;


    private static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        ATTACK_POINT_LIST = new ArrayList<>();

        // 转成完整棋盘数据
        int[][] matrix = convertToBoard(queens, king);

        // 水平/垂直搜索
        commonSearch(matrix, king);
        // 对角线搜索
        diagonalSearch(matrix, king);

        return ATTACK_POINT_LIST;
    }

    /**
     * 把 queue 数组转成完整的棋盘
     * @param queens
     * @param king
     * @return
     */
    private static int[][] convertToBoard(int[][] queens, int[] king) {
        int[][] matrix = new int[8][8];
        for (int[] queen : queens) {
            matrix[ queen[0] ] [ queen[1] ] = QUEEN;
        }
        matrix[king[0]][king[1]] = KING;

        return matrix;
    }

    /**
     * 水平/垂直搜索
     * @param matrix
     * @param king
     */
    private static void commonSearch(int[][] matrix, int[] king) {
        // 向左
        int x = king[0], y = king[1];
        while (y >= 0) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            y--;
        }

        // 向右
        x = king[0];
        y = king[1];
        while (y < matrix[0].length) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            y++;
        }

        // 向上
        x = king[0];
        y = king[1];
        while (x >= 0) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            x--;
        }

        // 向下
        x = king[0];
        y = king[1];
        while (x < matrix.length) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            x++;
        }
    }

    /**
     * 对角线搜索
     * @param matrix
     * @param king
     */
    private static void diagonalSearch(int[][] matrix, int[] king) {
        // 左上
        int x = king[0];
        int y = king[1];
        while (x >= 0 && y >= 0) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            x--;
            y--;
        }

        // 右下
        x = king[0];
        y = king[1];
        while (x < matrix.length && y < matrix[0].length) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            x++;
            y++;
        }

        // 左下
        x = king[0];
        y = king[1];
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            x++;
            y--;
        }

        // 右上
        x = king[0];
        y = king[1];
        while (x >=0 && y < matrix[0].length) {
            if (matrix[x][y] == QUEEN) {
                add(x, y);
                break;
            }
            x--;
            y++;
        }
    }

    private static void add(int x, int y) {
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        ATTACK_POINT_LIST.add(list);
    }


    public static void main(String[] args) {

    }

}
