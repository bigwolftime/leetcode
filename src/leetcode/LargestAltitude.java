package leetcode;

/**
 * 找到最高海拔
 * https://leetcode-cn.com/problems/find-the-highest-altitude/
 */
public class LargestAltitude {

    private static int largestAltitude(int[] gain) {
        int maxAltitude = 0, curAltitude = 0;

        for (int val : gain) {
            curAltitude += val;
            maxAltitude = Math.max(maxAltitude, curAltitude);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {

    }

}
