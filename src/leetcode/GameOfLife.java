package leetcode;

/**
 * 生命游戏<br/>
 * <a href="https://leetcode.cn/problems/game-of-life/">...</a>
 * <br/>
 *
 * 此题的关键是: 如何做到不额外开辟空间, 达到状态的同时变化<br/>
 *
 * 虽然做出了, 但我想问此题的意义在哪呢? 如今的硬件远没有像以前那样受制于空间的限制, 需要程序员绞尽脑汁去做优化.<br/>
 *
 * 如果在着手开发一个偏底层或者框架类的项目, 为追求性能而牺牲一些可读性无可厚非, 因为其抽象程度较高, 无需过度关注具体业务, 且后续改动较少,
 * 例如各种算法(KMP, 马拉车), 它需要你懂吗? 不一定, 性能卓越就完事了, 类似的还有大名鼎鼎的 Spring;<br/>
 * 但我相信, 大多数程序员在日常工作中的项目都偏向于业务类, 很少遇到编写底层框架的情况, 除非排查问题或者秉持学习的态度而去研读. 而对于此类项目,
 * 一方面写出的代码要追求时间和空间上的优势, 以节省资源, 提高性能; 但另一方面, 代码由人来开发, 后面自然也要人来维护, 一段可读性较低的代码,
 * 哪怕性能卓越, 也只能让人驻足远观, 不能把玩.<br/>
 *
 * 因此需要在性能和可维护性方面讲究平衡.
 * 此题的原地算法思路用在偏底层框架上没有问题, 因为在保证卓越性能的同时也降低了资源消耗, 但用在业务代码上, 我想说依托答辩, 毫无意义
 *
 * @author liuxin
 * @date 2024/3/11 20:38
 */
public class GameOfLife {

    private static final int DEAD = 0;
    private static final int ALIVE = 1;
    private static final int DEAD_TO_ALIVE = 2;
    private static final int ALIVE_TO_DEAD = 3;


    private static void gameOfLife(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {

                int val = board[x][y];
                int lifeCount = lifeCount(board, x, y);

                if (val == DEAD && lifeCount == 3) {
                    board[x][y] = DEAD_TO_ALIVE;
                } else if (val == ALIVE && (lifeCount < 2 || lifeCount > 3)) {
                    board[x][y] = ALIVE_TO_DEAD;
                }

            }
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                int val = board[x][y];
                if (val == DEAD_TO_ALIVE) {
                    board[x][y] = ALIVE;
                } else if (val == ALIVE_TO_DEAD) {
                    board[x][y] = DEAD;
                }
            }
        }

    }

    private static int lifeCount(int[][] board, int x, int y) {
        int lifeCount = 0;

        boolean isLeftValid = x - 1 >= 0;
        boolean isRightValid = x + 1 < board.length;
        boolean isUpValid = y - 1 >= 0;
        boolean isDownValid = y + 1 < board[0].length;

        // left
        if (isLeftValid && (board[x - 1][y] == ALIVE || board[x - 1][y] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        // right
        if (isRightValid && (board[x + 1][y] == ALIVE || board[x + 1][y] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        // up
        if (isUpValid && (board[x][y - 1] == 1 || board[x][y - 1] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        // down
        if (isDownValid && (board[x][y + 1] == 1 || board[x][y + 1] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        // up left
        if (isUpValid && isLeftValid && (board[x - 1][y - 1] == ALIVE || board[x - 1][y - 1] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        // up right
        if (isUpValid && isRightValid && (board[x + 1][y - 1] == ALIVE || board[x + 1][y - 1] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        // down left
        if (isDownValid && isLeftValid && (board[x - 1][y + 1] == ALIVE || board[x - 1][y + 1] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        // down right
        if (isDownValid && isRightValid && (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == ALIVE_TO_DEAD)) {
            lifeCount++;
        }

        return lifeCount;
    }


    public static void main(String[] args) {

    }

}
