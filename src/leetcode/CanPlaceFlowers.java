package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/4/28 15:48
 *
 * 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/
 *
 * 思路：判断连续的 0 的个数，达到 2 则判断下一位是不是 0，若是 0 则可以种植(n--)
 * 数组的第一位和最后一位是特殊情况，需注意。
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, gap = 1;
        while (i < flowerbed.length && n > 0){
            if (flowerbed[i] == 0){
                gap++;

                if (gap == 2){
                    if ((i + 1 < flowerbed.length && flowerbed[i + 1] == 0) || i + 1 == flowerbed.length){
                        n--;
                        gap = 0;
                    }else {
                        gap = 0;
                        i++;
                    }
                }
            }else {
                gap = 0;
            }
            i++;
        }

        return n == 0;
    }

    public static void main(String[] args) {
        int[] flowered = new int[]{1,0,0,0,1,0,0};
        int n = 2;
        System.err.println(canPlaceFlowers(flowered, n));
    }
}
