package lcp;

/**
 * 猜数字
 * https://leetcode-cn.com/problems/guess-numbers/
 *
 * @author liuxin
 * @time 2020/6/18 16:47
 */
public class Game {

    private static int game(int[] guess, int[] answer) {
        int success = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == guess[i]) {
                success++;
            }
        }

        return success;
    }

    public static void main(String[] args) {

    }

}
