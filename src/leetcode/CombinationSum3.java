package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * @author liuxin
 * @time 2020/9/11 9:56
 */
public class CombinationSum3 {

    private static HashSet<List<Integer>> set;

    private static List<List<Integer>> combinationSum3(int k, int n) {
        set = new HashSet<>();

        dfs(1, k, n, new ArrayList<>());

        return new ArrayList<>(set);
    }

    private static void dfs(int cur, int k, int n, List<Integer> list) {
        if (n == 0 && list.size() == k) {
            set.add(list);
            return;
        }

        if (cur > 9) {
            return;
        }
        if (n < 0) {
            return;
        }
        if (list.size() > k) {
            return;
        }

        List<Integer> originList = new ArrayList<>(list);
        list.add(cur);
        dfs(cur + 1, k, n - cur, list);
        dfs(cur + 1, k, n, originList);
    }

    public static void main(String[] args) {

    }

}
