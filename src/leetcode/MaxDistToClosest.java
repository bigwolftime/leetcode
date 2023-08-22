package leetcode;

/**
 * 到最近的人的最大距离
 * https://leetcode.cn/problems/maximize-distance-to-closest-person/
 *
 * 考虑其中一边为 0 的场景, 此时不用 / 2, 另外除法向上取整
 *
 * @author liuxin
 * @date 2023/8/22 15:19
 */
public class MaxDistToClosest {

    private static int maxDistToClosest(int[] seats) {
        int[] result = new int[seats.length];
        result[0] = seats[0] == 0 ? 1 : 0;

        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 1) {
                result[i] = 0;
            } else {
                result[i] = result[i - 1] + 1;
            }
        }

        if (seats[0] == 0) {
            // 从左开始全部*2
            for (int i = 0; i < seats.length; i++) {
                if (result[i] != 0) {
                    result[i] = result[i] * 2;
                } else {
                    break;
                }
            }
        }
        if (seats[seats.length - 1] == 0) {
            for (int i = seats.length - 1; i >= 0; i--) {
                if (result[i] != 0) {
                    result[i] = result[i] * 2;
                } else {
                    break;
                }
            }
        }

        int max = 0;
        for (int i : result) {
            max = Math.max(i, max);
        }

        return (int) (Math.ceil(max / 2.0d));
    }


    public static void main(String[] args) {
        int[] nums = new int[]{ 1,0,0,0,1,0,1 };
        // 1,0,0,0 -> 0,1,2,3
        // 0,0,0,1 -> 1,2,3,0
        // 0,0,1,0 -> 1,2,0,1
        // 0,1,0,0 -> 1,0,1,2
        // 1,0,0,1 -> 0,1,2,0
        // 1,0,0,0,1,0,1 -> 0,1,2,3,0,1,0
        int i = maxDistToClosest(nums);
        System.err.println(i);
    }

}
