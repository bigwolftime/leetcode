package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 将数组和减半的最少操作次数
 * https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
 *
 * @author liuxin
 * @date 2023/7/25 20:02
 */
public class HalveArray {

    private static int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            priorityQueue.add((double) (num));
            sum += num;
        }

        double halfVal = (double) sum / 2;
        int cnt = 0;

        while (true) {
            double poll = priorityQueue.poll();
            double decrVal = poll / 2;
            halfVal -= decrVal;
            cnt++;

            priorityQueue.add(decrVal);

            if (halfVal <= 0) {
                return cnt;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 5,19,8,1 };
        halveArray(nums);
    }

}
