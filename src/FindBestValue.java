import java.util.Arrays;

/**
 * 转变数组后最接近目标值的数组和
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 *
 * @author liuxin
 * @date 2020/6/14 10:07
 */
public class FindBestValue {

    private static int findBestValue(int[] arr, int target) {
        // 排序
        Arrays.sort(arr);

        // 前缀和
        int[] sumArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sumArr[i + 1] = sumArr[i] + arr[i];
        }

        // 暴力 O(N) 解法

        // 枚举的最小值 和 最大值
        int diff = Integer.MAX_VALUE;
        int min = 0, max = arr[arr.length - 1];
        int idx = 0;
        int sum;
        int res = 0;
        int tempDiff;

        while (min <= max) {
            while (min > arr[idx]) {
                idx++;
            }

            sum = sumArr[idx] + (arr.length - idx) * min;
            tempDiff = Math.abs(target - sum);
            if (tempDiff < diff) {
                diff = tempDiff;
                res = min;
            }

            if (sum >= target) {
                break;
            }

            min++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.err.println(findBestValue(new int[]{15, 1, 1, 1}, 50));
    }

}
