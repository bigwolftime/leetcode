package leetcode;

/**
 * 第 K 个缺失的正整数
 * https://leetcode-cn.com/problems/kth-missing-positive-number/
 */
public class FindKthPositive {

    private static int findKthPositive(int[] arr, int k) {
        int x = 1;
        for (int value : arr) {
            while (x != value) {
                k--;
                if (k == 0) {
                    return x;
                }
                x++;
            }
            x++;
        }

        int last = arr[arr.length - 1];
        while (k > 0) {
            last++;
            k--;
        }

        return last;
    }

    public static void main(String[] args) {
        findKthPositive(new int[]{ 2,3,4,7,11 }, 5);
    }

}
