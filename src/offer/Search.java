package offer;

/**
 * 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * 还可以使用二分优化
 */
public class Search {

    private static int search(int[] nums, int target) {
        int count = 0;
        for (int i : nums) {
            if (i == target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
