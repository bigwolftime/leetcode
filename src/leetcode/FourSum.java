package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 四数之和
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author liuxin
 * @date 2020/10/5 8:32
 */
public class FourSum {

    private static HashSet<List<Integer>> set;

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {

                for (int k = j + 1; k < nums.length - 1; k++) {
                    int left = target - nums[i] - nums[j] - nums[k];

                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[l] > left) {
                            break;
                        } else if (nums[l] == left) {
                            save(i, j, k, l, nums);
                        }
                    }
                }

            }

        }

        return new ArrayList<>(set);
    }

    private static void save(int i, int j, int k, int l, int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[i]);
        list.add(nums[j]);
        list.add(nums[k]);
        list.add(nums[l]);

        set.add(list);
    }

    public static void main(String[] args) {

    }

}
