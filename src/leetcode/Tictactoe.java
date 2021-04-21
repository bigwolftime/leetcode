package leetcode;

/**
 * 找出井字棋的获胜者
 * https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game/
 *
 * 模拟，然后逐行，逐列，两个对角线判断相等
 */
public class Tictactoe {

    private static String tictactoe(int[][] moves) {
        int OPERATOR = 1;

        int count = 0;
        int[][] arr = new int[3][3];

        for (int[] move : moves) {
            arr[move[0]][move[1]] = OPERATOR;
            OPERATOR = -OPERATOR;

            count++;

            if (count >= 3) {
                // 判断优胜
                int winner = judgeWinner(arr);
                if (winner != 0) {
                    return winner == 1 ? "A" : "B";
                }
                if (count >= 9) {
                    return "Draw";
                }
            }
        }

        return "Pending";
    }

    private static int judgeWinner(int[][] arr) {
        // 逐行判断
        for (int[] ints : arr) {
            int x = ints[0];

            if (x == 0) {
                continue;
            }

            boolean flag = true;

            for (int j = 1; j < ints.length; j++) {
                if (ints[j] != x) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return x;
            }
        }

        // 逐列判断
        for (int i = 0; i < arr[0].length; i++) {
            int x = arr[0][i];

            if (x == 0) {
                continue;
            }

            boolean flag = true;

            for (int j = 1; j < arr.length; j++) {
                if (x != arr[j][i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return x;
            }
        }

        // 两个对角线
        int val = arr[0][0];
        boolean flag = true;
        for (int i = 1; i < arr.length && val != 0; i++) {
            if (val != arr[i][i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return val;
        }

        flag = true;
        int x = 0, y = 2;
        val = arr[x][y];
        for (int i = 1; i < 3 && val != 0; i++) {
            x++;
            y--;

            if (val != arr[x][y]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return val;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] moves = new int[][]{
                {0,0},{1,1},{2,0}, {1,0}, {1,2},{2,1},{0,1},{0,2},{2,2}
        };

        System.err.println(tictactoe(moves));
    }

}
