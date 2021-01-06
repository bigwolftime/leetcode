package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数对和
 * https://leetcode-cn.com/problems/pairs-with-sum-lcci/
 */
public class PairSums {

    private static List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> resList = new ArrayList<>();

        int p = 0, q = nums.length - 1;
        int sum;
        while (p < q) {
            sum = nums[p] + nums[q];

            if (sum > target) {
                q--;
            } else if (sum < target) {
                p++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[p]);
                list.add(nums[q]);
                resList.add(list);

                p++;
                q--;
            }

        }

        return resList;
    }

    public static void main(String[] args) {

    }

}
