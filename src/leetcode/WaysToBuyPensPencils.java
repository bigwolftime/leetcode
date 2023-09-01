package leetcode;

/**
 * 买钢笔和铅笔的方案数
 * https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils
 *
 * 单纯递归, 即使加上剪枝也不太行, 比如 100000,1,1 会导致栈溢出
 * 然后用枚举, 简单实惠
 *
 * @author liuxin
 * @date 2023/9/1 15:36
 */
public class WaysToBuyPensPencils {


    private static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 > cost2) {
            return calc(total, cost2, cost1);
        }
        return calc(total, cost1, cost2);
    }

    private static long calc(int total, int cost1, int cost2) {
        long cnt = 0;

        int maxCnt1 = total / cost1;
        for (long i = 0; i <= maxCnt1; i++) {
            cnt += (total - cost1 * i) / cost2 + 1;
        }

        return cnt;
    }


    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long l = waysToBuyPensPencils(20, 10, 5);
        System.err.println(l);
        System.err.println(System.currentTimeMillis() - time);
    }

}
