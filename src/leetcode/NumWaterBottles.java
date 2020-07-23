package leetcode;

/**
 * 换酒问题
 * https://leetcode-cn.com/problems/water-bottles/
 *
 * @author liuxin
 * @date 2020/7/23 22:08
 */
public class NumWaterBottles {

    private static int numWaterBottles(int numBottles, int numExchange) {
        int left = 0;
        int count = numBottles;
        do {
            // 剩余的空瓶子
            left += (numBottles % numExchange);

            numBottles /= numExchange;
            // 喝酒的瓶子数
            count += numBottles;

            numBottles += (left % numExchange);
            left %= numExchange;    
        } while (left < numExchange);

        return count;
    }

    public static void main(String[] args) {
        numWaterBottles(15, 4);
    }

}
