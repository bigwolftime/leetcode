package leetcode;

/**
 * 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * 这也能用到二分我tm没想到
 *
 * 最终的运力结果 res：应该在 [left, right] 之间，left 是数组中的最大元素值(这是要保证的最低运力)，right 是所有元素加和(一次性全运喽)
 * 那么 res 就在此范围内以二分法进行试探即可，取满足条件的最小 res
 */
public class ShipWithinDays {

    private static int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (shipWithinDays(weights, D, mid)) {
                // 运力足够，尝试降低运力
                right = mid;
            } else {
                // 运力不够
                left = mid + 1;
            }
        }

        return shipWithinDays(weights, D, left) ? left : left + 1;
    }

    /**
     *
     * @param weights
     * @param D         天数
     * @param res       运力
     * @return
     */
    private static boolean shipWithinDays(int[] weights, int D, int res) {
        for (int i = 0; i < weights.length; i++) {
            int curSum = 0;

            for (int j = i; j < weights.length; j++) {

                if (curSum + weights[j] > res) {
                    D--;
                    break;
                }

                curSum += weights[j];
                i = j;
            }

            if (i == weights.length - 1) {
                D--;
            }
        }

        return D >= 0;
    }


    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        shipWithinDays(weights, 5);
    }

}
