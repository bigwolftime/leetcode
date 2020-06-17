package leetcode;

import java.util.HashSet;

/**
 * @author Liuxin
 * @since 2019/6/27 20:11
 * <p>
 * 只出现一次的数字 II
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i : nums){
            if (set1.contains(i)){
                set2.add(i);
            }else {
                set1.add(i);
            }
        }

        set1.removeAll(set2);
        return set1.iterator().next();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 3};
        singleNumber(nums);
    }
}
