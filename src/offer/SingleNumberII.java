package offer;

import java.util.HashSet;

/**
 * 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class SingleNumberII {


    private static int singleNumber(int[] nums) {
        HashSet<Integer> dupSet = new HashSet<>(), singleSet = new HashSet<>();

        for (int val : nums) {
            if (dupSet.contains(val)) {
                continue;
            }

            if (singleSet.contains(val)) {
                singleSet.remove(val);
                dupSet.add(val);
                continue;
            }

            singleSet.add(val);
        }

        return singleSet.iterator().next();
    }

    public static void main(String[] args) {

    }

}
