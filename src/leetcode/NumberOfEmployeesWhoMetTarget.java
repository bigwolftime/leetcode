package leetcode;

/**
 * 满足目标工作时长的员工数
 * <a href="https://leetcode.cn/problems/number-of-employees-who-met-the-target">...</a>
 *
 * @author liuxin
 * @date 2024/4/30 11:20
 */
public class NumberOfEmployeesWhoMetTarget {

    private static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;
        for (int hour : hours) {
            if (hour >= target) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

    }

}
