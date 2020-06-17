package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/3/14 14:17
 *
 * 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/submissions/
 */
class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int res = 0;

        while (i <= j){
            res += nums[i++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.err.println(numArray.sumRange(0, 5));
    }
}
