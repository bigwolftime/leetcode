package leetcode;

/**
 * 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * 总觉得题目没有描述清楚
 * 1. 为啥范围在 [1, n + 1] ?
 *
 * @author liuxin
 * @date 2020/6/27 8:08
 */
public class FirstMissingPositive {

    private static int firstMissingPositive(int[] nums) {
        int cur;
        int temp;
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i + 1 && nums[i] > 0 && nums[i] < nums.length) {
                cur = nums[i];

                if (cur == nums[cur - 1]) {
                    break;
                }

                temp = nums[cur - 1];
                nums[cur - 1] = cur;
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.err.println(firstMissingPositive(new int[]{ 1,1 }));;
    }

}
