import java.util.HashMap;

/**
 * 查找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * 1. 不能更改原数据
 * 2. 只能使用 O(1) 的空间
 * 这两个条件相当于禁止 hash, 排序 的思路
 *
 * 使用了"二分法", 使用此办法前提条件是: 数字 1-n 之间, n + 1 个元素
 * 例如: 2,4,5,2,3,1,6,7 以中位数 4 为例, 计算 <= 4 的个数: 5 个
 * 5 >= 8的一半, 所以重复数字在 <= 4 的区间.
 *
 * @author liuxin
 * @time 2020/5/26 11:57
 */
public class FindDuplicate {

    private static int findDuplicate(int[] nums) {
        int mid = nums.length >> 1;
        int count = 0;
        int start = 1, end = nums.length - 1;

        while (true) {
            for (int i : nums) {
                if (i <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                end = mid;
            } else  {
                start = mid;
            }

            if (end - start <= 1 && mid == start) {
                return count > mid ? start : ((mid == end) ? start : end);
            }

            mid = start + ((end - start) >> 1);
            count = 0;
        }
    }

    public static void main(String[] args) {
        int duplicate = findDuplicate(new int[]{3,1,3,4,2});
        System.err.println(duplicate);
    }

}
