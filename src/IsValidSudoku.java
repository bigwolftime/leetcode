import java.util.HashSet;

/**
 * @author liuxin
 * @date 2020/5/31 14:18
 */
public class IsValidSudoku {

    /**
     * 验证横纵向
     *
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

    private static boolean verify(char[][] board, int startX, int startY, int endX, int endY) {
        HashSet<Character> set = new HashSet<>();
        char c;

        for (; startX <= endX; startX++) {
            for (; startY <= endY; startY++) {
                c = board[startX][startY];

                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }

            startY -= 3;
        }
        set.clear();

        return true;
    }


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
        for (int x = 0; x <= 6; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                boolean verify = verify(board, x, y, x + 2, y + 2);
                if (!verify) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','.',  '.','.','.',   '5','.','.'},
                {'.','.','.',  '.','.','.',   '.','.','.'},
                {'.','.','.',  '.','.','.',   '.','.','.'},

                {'9','3','.',  '.','2','.',   '4','.','.'},
                {'.','.','7',  '.','.','.',   '3','.','.'},
                {'.','.','.',  '.','.','.',   '.','.','.'},

                {'.','.','.',  '3','4','.',   '.','.','.'},
                {'.','.','.',  '.','.','3',   '.','.','.'},
                {'.','.','.',  '.','.','5',   '2','.','.'}
        };

        System.err.println(isValidSudoku(board));
    }

}
