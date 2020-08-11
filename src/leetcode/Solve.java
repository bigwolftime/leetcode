package leetcode;

/**
 * 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * 与边界的 O 直接相连或者间接相连的 O 都不能转化为 X. 其他的 O 可以
 * 使用 染色 + DFS 的办法.
 *
 * @author liuxin
 * @time 2020/8/11 21:02
 */
public class Solve {

    private static void solve(char[][] board) {
        int len = board.length;
        // 感染
        for (int i = 0; i < len; i++) {
            dfs(board, 0, i, 0, i);
        }
        for (int i = 1; i < len; i++) {
            dfs(board, i, len - 1, i, len - 1);
        }
        for (int i = len)

             //& 置换

        // 重置
        restore(board);
    }

    private static void dfs(char[][] board, int x, int y, int preX, int preY) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            // x, y 不符合 -> 结束
            return;
        }

        if (board[x][y] == 'X') {
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

    private static void restore(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                { 'X', 'X', 'X', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'X', 'O', 'X' }
        };

        solve(board);
    }

}
