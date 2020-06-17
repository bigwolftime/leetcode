package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/4/4 11:18
 *
 * 提莫攻击
 * https://leetcode-cn.com/problems/teemo-attacking/
 */
public class FindPoisonedDuration {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0){
            return 0;
        }

        int total = 0, pre = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++){
            if (timeSeries[i] - timeSeries[i - 1] >= duration){
                total += duration;
            }else {
                total += timeSeries[i] - timeSeries[i - 1];
            }
        }
        total += duration;

        return total;
    }

    public static void main(String[] args) {
        int[] timeSeries = new int[]{};
        System.err.println(findPoisonedDuration(timeSeries, 100));
    }
}
