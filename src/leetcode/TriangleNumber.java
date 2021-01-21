package leetcode;

import java.util.Arrays;

/**
 * 有效三角形的个数
 * https://leetcode-cn.com/problems/valid-triangle-number/
 */
public class TriangleNumber {

    private static int triangleNumber(int[] nums) {
        int count = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int a = nums[i], b = nums[j], c = nums[k];

                    if (a + b > c) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
