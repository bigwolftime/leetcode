import java.util.HashMap;

/**
 * 和为 K 的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 思路: sum(i,j) = sum(0,j) - sum(0,i)
 * hash 出每个位置的总和. 空间换时间
 */
public class SubArraySum {

    private static int subArraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, nums[0]);

        for (int i = 1; i < nums.length; i++) {
            map.put(i, map.get(i - 1) + nums[i]);
        }

        int count = 0;

        int i = 0, j = 0;
        /*while (j < )*/

        return count;
    }

    public static void main(String[] args) {
        subArraySum(new int[]{1,2,2,3,3,5}, 7);
    }
}
