package leetcode;

/**
 * 计算列车到站时间
 * https://leetcode.cn/problems/calculate-delayed-arrival-time
 *
 * @author liuxin
 * @date 2023/9/8 16:53
 */
public class FindDelayedArrivalTime {

    private static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public static void main(String[] args) {
        int delayedArrivalTime = findDelayedArrivalTime(13, 11);
        System.err.println(delayedArrivalTime);
    }

}
