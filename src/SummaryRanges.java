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

    private static String pattern = "%s->%s";

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        int min = nums[0], max = nums[nums.length - 1];
        if (min == max){
            return new ArrayList<String>(){{ add(String.valueOf(nums[0])); }};
        }

        int cur = 0, offset = 0;
        while (min <= max){
            if (min + 1 != nums[cur + 1]){

            }
        }

        System.err.println(res);
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,4,6,8,9};
        summaryRanges(nums);
    }

}
