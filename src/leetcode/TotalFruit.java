package leetcode;

/**
 * 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/
 *
 * @author liuxin
 * @date 2022/10/17 20:35
 */
public class TotalFruit {

    private static int totalFruit(int[] fruits) {
        if (fruits.length == 0) {
            return 0;
        }
        if (fruits.length == 1) {
            return 1;
        }

        int total = 0;
        int startIdx = 0;
        int prefixTotal = initPrefixTotal(fruits);

        while (startIdx < fruits.length) {
            CalcFruit calcFruit = calcTotalFruits(fruits, startIdx, prefixTotal);

            startIdx = calcFruit.nextStartIdx;
            prefixTotal = calcFruit.prefixTotal;
            total = Math.max(total, calcFruit.total);
        }

        return total;
    }


    private static int initPrefixTotal(int[] fruits) {
        int i = 0;
        int val = fruits[i++];

        while (i < fruits.length) {
            if (fruits[i] != val) {
                return i;
            }

            i++;
        }

        return i;
    }

    /**
     *
     * @param fruits
     * @param startIdx  起始索引
     * @return arr[0]: total  arr[1]: nextStartIdx  arr[2]: prefixTotal
     */
    private static CalcFruit calcTotalFruits(int[] fruits, int startIdx, int prefixTotal) {
        int lastVal = fruits[startIdx];
        int lVal = fruits[startIdx];
        int nextStartIdx = startIdx;
        startIdx += prefixTotal;

        if (startIdx >= fruits.length) {
            return new CalcFruit(prefixTotal, startIdx,0);
        }

        int rightVal = fruits[startIdx];

        int lCnt = prefixTotal, rCnt = 0;

        while (startIdx < fruits.length) {
            int curVal = fruits[startIdx];
            if (curVal != lVal && curVal != rightVal) {
                return new CalcFruit(lCnt + rCnt, nextStartIdx, startIdx - nextStartIdx);
            }

            if (curVal == lVal) {
                lCnt++;
            } else {
                rCnt++;
            }

            if (curVal != lastVal) {
                nextStartIdx = startIdx;
                lastVal = curVal;
            }

            startIdx++;
        }

        return new CalcFruit(lCnt + rCnt, startIdx, startIdx - nextStartIdx);
    }

    private static class CalcFruit {

        /**
         * 本次计算数量
         */
        int total;

        /**
         * 下次起始索引
         */
        int nextStartIdx;

        int prefixTotal;


        public CalcFruit(int total, int nextStartIdx, int prefixTotal) {
            this.total = total;
            this.nextStartIdx = nextStartIdx;
            this.prefixTotal = prefixTotal;
        }
    }


    public static void main(String[] args) {
        int i = totalFruit(new int[]{1,1});
        System.err.println(i);
    }

}
