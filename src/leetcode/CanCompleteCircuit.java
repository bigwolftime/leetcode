package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/4/1 16:25
 *
 * 加油站
 * https://leetcode-cn.com/problems/gas-station/
 *
 * 目前的思路就是通过循环，依次判断
 */
public class CanCompleteCircuit {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;

        for (int i = 0; i < gas.length; i++) {
            remain = looping(gas, cost, i, remain);
            if (remain >= 0){
                return i;
            }
            remain = 0;
        }

        return -1;
    }

    private static int looping(int[] gas, int[] cost, int index, int remain) {
        int count = gas.length, idx;

        for (int i = 0; i < count; i++, index++) {
            idx = index < count ? index : index % count;
            remain += gas[idx];

            if (remain < cost[idx]){
                return -1;
            }else {
                remain -= cost[idx];
            }
        }

        return remain;
    }

    public static void main(String[] args) {
        int[] gas =  new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};

        canCompleteCircuit(gas, cost);
    }
}
