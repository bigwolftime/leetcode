package leetcode;

/**
 * 所有蚂蚁掉下来前的最后一刻
 * https://leetcode-cn.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 *
 * 脑筋急转弯
 * 不用考虑碰撞变向，直接穿过去完事了
 */
public class GetLastMoment {

    private static int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;

        for (int i : left) {
            if (i > max) {
                max = i;
            }
        }

        for (int i : right) {
            if (n - i > max) {
                max = n - i;
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }

}
