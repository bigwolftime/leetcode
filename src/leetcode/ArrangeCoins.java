package leetcode;

/**
 * 排列硬币
 * https://leetcode-cn.com/problems/arranging-coins/
 */
public class ArrangeCoins {

    private static int arrangeCoins(int n) {
        int lv = 0;
        int base = 1;

        while (n - base >= 0) {
            lv++;
            n -= base;
            base++;
        }

        return lv;
    }

    public static void main(String[] args) {

    }

}
