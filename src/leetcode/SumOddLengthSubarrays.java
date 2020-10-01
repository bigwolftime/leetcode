package leetcode;

/**
 * 所有奇数长度子数组的和
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 *
 * @author liuxin
 * @time 2020/9/29 14:34
 */
public class SumOddLengthSubarrays {

    private static int sumOddLengthSubArrays(int[] arr) {
        int sum = 0;
        for (int windowLength = 1; windowLength <= arr.length; windowLength += 2) {

            for (int start = 0; start <= arr.length - windowLength; start++) {
                sum += sum(arr, start, start + windowLength - 1);
            }

        }

        return sum;
    }

    private static int sum(int[] arr, int startIdx, int endIdx) {
        int sum = 0;
        for (; startIdx <= endIdx; startIdx++) {
            sum += arr[startIdx];
        }

        return sum;
    }

    public static void main(String[] args) {

    }

}
