package leetcode;

/**
 * 最接近目标价格的甜点成本
 * https://leetcode.cn/problems/closest-dessert-cost/
 *
 * 暴力递归+回溯
 *
 * @author liuxin
 * @date 2022/12/4 11:24 AM
 */
public class ClosestCost {

    private static int CLOSEST_COST;

    private static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        CLOSEST_COST = Integer.MAX_VALUE;

        for (int baseCost : baseCosts) {
            if (CLOSEST_COST == target) {
                break;
            }

            cost(baseCost, toppingCosts, 0, 0, target);
        }

        return CLOSEST_COST;
    }

    private static void cost(int curVal, int[] toppingCosts, int toppingCostsIdx, int toppingCostsTimes, int targetVal) {
        if (CLOSEST_COST == targetVal) {
            // 历史最近累加值 == target -> return
            return;
        }
        if (curVal == targetVal) {
            // 当前累加值 == target -> return
            CLOSEST_COST = curVal;
            return;
        }

        if (curVal > targetVal || toppingCostsIdx >= toppingCosts.length) {
            // curVal > targetVal || idx >= length -> stop match
            int abs1 = Math.abs(targetVal - curVal);
            int abs2 = Math.abs(targetVal - CLOSEST_COST);
            if (abs1 < abs2) {
                // compare abs val
                CLOSEST_COST = curVal;
            } else if (abs1 == abs2) {
                CLOSEST_COST = Math.min(CLOSEST_COST, curVal);
            }

            return;
        }


        if (toppingCostsTimes == 0 || toppingCostsTimes == 1) {
            // not use cur cost, next
            cost(curVal, toppingCosts, toppingCostsIdx + 1, 0, targetVal);
            // use cur cost, times++
            cost(curVal + toppingCosts[toppingCostsIdx], toppingCosts, toppingCostsIdx, toppingCostsTimes + 1, targetVal);
        } else if (toppingCostsTimes == 2) {
            // do not use cur cost, next idx
            cost(curVal, toppingCosts, toppingCostsIdx + 1, 0, targetVal);
        }
    }


    public static void main(String[] args) {
        closestCost(new int[]{ 1 }, new int[]{ 8,10 }, 10);

    }

}
