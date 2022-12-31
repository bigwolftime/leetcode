package leetcode;

import java.util.Arrays;

/**
 * 使每位学生都有座位的最少移动次数
 * https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/
 *
 * @author liuxin
 * @date 2022/12/31 2:44 PM
 */
public class MinMovesToSeat {

    private static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int cnt = 0;
        for (int i = 0; i < seats.length; i++) {
            cnt += Math.abs(seats[i] - students[i]);
        }

        return cnt;
    }


    public static void main(String[] args) {

    }

}
