package leetcode;

/**
 * 构成特定和需要的最少元素
 * https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/
 *
 * @author liuxin
 * @date 2022/12/16 10:20
 */
public class MinElements {

    private static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long diff = sum - goal;
        if (diff == 0) {
            return 0;
        }

        if (diff % limit == 0) {
            // 整除情况, 不用 +1
            return (int)(Math.abs(diff / limit));
        }

        // 非整除, +1
        return (int)(Math.abs(diff / limit)) + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,5,1,-2};
        int i = minElements(nums, 5, 126614243);
        System.err.println(i);
    }

}
