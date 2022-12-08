package leetcode;

/**
 * 判断国际象棋棋盘中一个格子的颜色
 * https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 *
 * @author liuxin
 * @date 2022/12/8 9:20 PM
 */
public class SquareIsWhite {

    public boolean squareIsWhite(String coordinates) {
        char xc = coordinates.charAt(0);
        int x = xc - 97;
        int y = Integer.parseInt(coordinates.substring(1)) - 1;

        return ((x + y) & 1) != 0;
    }




    public static void main(String[] args) {
        System.err.println(2 & 1);
    }

}
