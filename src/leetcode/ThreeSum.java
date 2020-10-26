package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 三数之和(相加为 0)
 *
 * 时间复杂度: O(N ^ 2 * logN)
 * 前两个数用 双指针, 第三个用二分
 *
 * @author liuxin
 * @time 2020/6/12 14:54
 */
public class ThreeSum {

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        HashSet<List<Integer>> set = new HashSet<>();

        int sum;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];

                // 二分
                int idx = binarySearch(j + 1, nums, -sum);
                if (idx != -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[idx]);
                    set.add(list);
                }

            }
        }

        return new ArrayList<>(set);
    }

    private static int binarySearch(int start, int[] nums, int target) {
        if (start >= nums.length || nums[start] > target) {
            return -1;
        }

        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + ((end - start) >> 1);

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        /*System.err.println(threeSum(new int[]{ -4,-1,-1,0,1,2 }));*/

        binarySearch(0, new int[]{ -4,-1,-1,0,1,2 }, 2);

    }

}
