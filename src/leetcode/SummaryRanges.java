package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuxin
 * @since 2019/8/1 18:13
 *
 * 汇总区间
 * https://leetcode-cn.com/problems/summary-ranges/
 *
 */
public class SummaryRanges {

    private static final String PATTERN = "%d->%d";

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        if (nums == null || nums.length == 0){
            return list;
        }

        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int start = 0, end = 1;

        do {
            if (nums[end] == nums[end - 1] + 1) {
                end++;
            } else {
                add(nums, start, end, list);

                start = end;
                end = start + 1;
            }
        } while (end < nums.length);

        add(nums, start, end, list);

        return list;
    }

    private static void add(int[] nums, int start, int end, List<String> list) {
        if (end - start > 1) {
            list.add(String.format(PATTERN, nums[start], nums[end - 1]));
        } else {
            list.add(String.valueOf(nums[start]));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.err.println(summaryRanges(nums));;
    }

}
