package leetcode;

/**
 * 重新排列数组
 * https://leetcode-cn.com/problems/shuffle-the-array/
 */
public class Shuffle4 {

    private static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];

        int p = 0, q = n;
        for (int i = 0; i < nums.length; i++) {
            arr[i++] = nums[p++];
            arr[i] = nums[q++];
        }

        return arr;
    }

    public static void main(String[] args) {

    }

}
