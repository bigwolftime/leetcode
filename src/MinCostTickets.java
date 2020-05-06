import java.util.HashSet;

/**
 * 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 *
 * 理解动态规划
 */
public class MinCostTickets {

    private static Integer[] mem;
    private static HashSet<Integer> daySet;
    private static int[] cost;

    static {
        daySet = new HashSet<>();
    }

    private static int minCostTickets(int[] days, int[] costs) {
        cost = costs;
        mem = new Integer[366];

        daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }

        return dp(1);
    }

    private static int dp(int i) {
        if (i > 365) {
            return 0;
        }

        if (mem[i] != null) {
            return mem[i];
        }

        if (daySet.contains(i)) {
            mem[i] = Math.min(Math.min(dp(i + 1) + cost[0], dp(i + 7) + cost[1]), dp(i + 30) + cost[2]);
        } else {
            mem[i] = dp(i + 1);
        }

        return mem[i];
    }

    public static void main(String[] args) {
        int[] day = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};
        int[] cost = new int[]{2, 7, 15};
        int i = minCostTickets(day, cost);
        System.err.println(i);
    }

}
