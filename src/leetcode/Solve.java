package leetcode;

/**
 * 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * 与边界的 O 直接相连或者间接相连的 O 都不能转化为 X. 其他的 O 可以
 * 使用 染色 + DFS 的办法.
 *
 * 染色完成后， 可以把 ‘O’ 变成 ‘X’
 *
 * 最后把 染色的元素还原即可
 *
 * @author liuxin
 * @time 2020/8/11 21:02
 */
public class Solve {

    private static void solve(char[][] board) {
        int xLen = board.length, yLen;
        if (board == null || xLen == 0 || (yLen = board[0].length) == 0) {
            return;
        }

        // 感染
        for (int i = 0; i < yLen; i++) {
            dfs(board, 0, i, 0, i);
        }
        for (int i = 1; i < xLen; i++) {
            dfs(board, i, yLen - 1, i, yLen - 1);
        }
        for (int i = yLen - 2; i >= 0; i--) {
            dfs(board, xLen - 1, i, xLen - 1, i);
        }
        for (int i = xLen - 2; i > 0; i--) {
            dfs(board, i, 0, i, 0);
        }

        // 置换
        change(board);

        // 重置
        restore(board);
    }

    private static void dfs(char[][] board, int x, int y, int preX, int preY) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            // x, y 不符合 -> 结束
            return;
        }

        if (board[x][y] == 'X' || board[x][y] == 'Z') {
            // X 无需处理
            return;
        }

        // 'O' 处在边界, 那么直接染色
        boolean isBorder = x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1;
        boolean lastIsZ = board[preX][preY] == 'Z';
        if (isBorder || lastIsZ) {
            board[x][y] = 'Z';
        }

        dfs(board, x - 1, y, x, y);
        dfs(board, x + 1, y, x, y);
        dfs(board, x, y - 1, x, y);
        dfs(board, x, y + 1, x, y);
    }

    private static void change(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void restore(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' }
        };

        solve(board);
    }

}
