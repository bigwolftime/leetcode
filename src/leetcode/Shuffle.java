package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱数组
 * https://leetcode-cn.com/problems/shuffle-an-array/
 *
 * 洗牌算法: 已知前 [0, n - 1] 已洗牌, n 是否与 [0, n - 1] 中的某元素交换
 *
 * @author liuxin
 * @time 2020/10/9 11:27
 */
public class Shuffle {

    private final Random random;
    private final int[] originNums;
    private final int[] shuffleNums;

    public Shuffle(int[] nums) {
        originNums = Arrays.copyOf(nums, nums.length);
        shuffleNums = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    public int[] reset() {
        return originNums;
    }

    public int[] shuffle() {
        int temp;

        for (int i = 0; i < shuffleNums.length; i++) {
            if (random.nextBoolean() && i + 1 < shuffleNums.length) {
                // 交换
                int j = i + 1;
                // 区间: 左开右闭, 所以此处用 i + 1
                int randomIdx = random.nextInt(i + 1);
                temp = shuffleNums[randomIdx];
                shuffleNums[randomIdx] = shuffleNums[j];
                shuffleNums[j] = temp;
            }
        }

        return shuffleNums;
    }


    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.err.println(random.nextInt(3));
        }
    }

}
