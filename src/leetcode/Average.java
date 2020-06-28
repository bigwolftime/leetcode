package leetcode;

/**
 * 去掉最低工资和最高工资后的平均值
 * https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 *
 * 双周赛 29 第一题
 *
 * @author liuxin
 * @time 2020/6/28 15:32
 */
public class Average {

    private static double average(int[] salary) {
        if (salary.length == 1) {
            return salary[0];
        }
        if (salary.length == 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i : salary) {
            max = Math.max(max, i);
            min = Math.min(min, i);

            sum += i;
        }

        return (double) (sum - min - max) / (salary.length - 2);
    }

    public static void main(String[] args) {

    }

}
