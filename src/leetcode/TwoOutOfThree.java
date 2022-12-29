package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 至少在两个数组中出现的值
 * https://leetcode.cn/problems/two-out-of-three/
 *
 * @author liuxin
 * @date 2022/12/29 10:05 AM
 */
public class TwoOutOfThree {


    private static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();

        int[] cntArr = new int[100];
        cnt(nums1, cntArr);
        cnt(nums2, cntArr);
        cnt(nums3, cntArr);


        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] >= 2) {
                list.add(i + 1);
            }
        }

        return list;
    }


    private static void cnt(int[] nums, int[] cntArr) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }

            cntArr[num - 1]++;
            set.add(num);
        }
    }


    public static void main(String[] args) {

    }

}
