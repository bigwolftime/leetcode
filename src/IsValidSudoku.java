import java.util.HashSet;

/**
 * @author liuxin
 * @date 2020/5/31 14:18
 */
public class IsValidSudoku {

    private static boolean isValidSudoku(char[][] board) {
        // 验证横向
        if (!verify(board, true)) {
            return false;
        }

        // 要验证纵向
        if (!verify(board, false)) {
            return false;
        }

        HashSet<Character> set = new HashSet<>();

        // 验证每个九宫格
        int x, y;
        int tempX, tempY;
        char c;
        for (y = 2; y <= 8; y += 3) {
            for (x = 0; x <= 6; x += 3) {

                tempX = x;
                tempY = y;

                for (; tempX < x + 3; tempX++) {
                    for (; tempY >= 0; tempY--) {
                        c = board[tempY][tempX];
                        if (c != '.' && !set.add(c)) {
                            return false;
                        }
                    }
                }

                set.clear();
            }
        }

        return true;
    }

    /**
     * 验证横纵向
     * @param board
     * @param horizontal
     * @return
     */
    private static boolean verify(char[][] board, boolean horizontal) {
        HashSet<Character> set = new HashSet<>();
        char c;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                c = horizontal ? board[i][j] : board[j][i];

                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
            set.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };

        System.err.println(isValidSudoku(board));
    }

}
