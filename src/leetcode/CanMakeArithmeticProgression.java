package leetcode;

import java.util.Arrays;

/**
 * 判断能否形成等差数列
 * https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 */
public class CanMakeArithmeticProgression {

    private static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }

        Arrays.sort(arr);

        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
