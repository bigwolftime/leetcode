package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 好数对的数目
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 *
 * i < j && nums[i] == nums[j] 则称为好数对
 * 思路: 计算每个数字出现的次数, 对于每个元素, 好数对的计算方式为: n * (n - 1) // 2
 *
 * @author liuxin
 * @time 2020/7/13 10:24
 */
public class NumIdenticalPairs {

    private static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer count;

        for (int i : nums) {
            count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count = entry.getValue();
            res += (count * (count - 1) / 2);
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
