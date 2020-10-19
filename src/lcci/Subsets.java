package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 幂集
 * https://leetcode-cn.com/problems/power-set-lcci/
 *
 * 回溯 + 剪枝 + 循环
 *
 * @author liuxin
 * @time 2020/10/19 14:51
 */
public class Subsets {

    private static HashSet<List<Integer>> set;

    private static List<List<Integer>> subsets(int[] nums) {
        set = new HashSet<>();
        set.add(new ArrayList<>());
        Arrays.sort(nums);

        for (int count = 1; count <= nums.length; count++) {
            dfs(0, nums, new ArrayList<>(), count);
        }

        return new ArrayList<>(set);
    }

    private static void dfs(int curIdx, int[] nums, List<Integer> list, int count) {
        if (list.size() == count) {
            // 数据已足够
            set.add(list);
            return;
        }

        if (curIdx >= nums.length) {
            // 溢出
            return;
        }

        if (nums.length - curIdx + list.size() < count) {
            // 剩余的数据已不足填充 list -> 结束
            return;
        }

        List<Integer> originList = new ArrayList<>(list);
        list.add(nums[curIdx]);
        dfs(curIdx + 1, nums, list, count);
        dfs(curIdx + 1, nums, originList, count);
    }

    public static void main(String[] args) {
        subsets(new int[]{ 1,2,3 });
    }

}
