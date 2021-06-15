package leetcode;

/**
 * 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/comments/
 */
public class PeakIndexInMountainArray {

    private static int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int cur = arr[i];
            if (arr[i - 1] < cur && cur > arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}
